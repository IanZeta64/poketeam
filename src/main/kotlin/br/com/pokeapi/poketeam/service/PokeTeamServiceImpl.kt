package br.com.pokeapi.poketeam.service

import br.com.pokeapi.poketeam.exceptions.TeamNotFoundException
import br.com.pokeapi.poketeam.dto.TeamDTORequest
import br.com.pokeapi.poketeam.dto.TeamDTOResponse
import br.com.pokeapi.poketeam.repository.TeamRepository
import br.com.pokeapi.poketeam.mapper.Mapper
import br.com.pokeapi.poketeam.message.Message
import br.com.pokeapi.poketeam.message.KafkaProducer
import br.com.pokeapi.poketeam.repository.AbilityRepository
import br.com.pokeapi.poketeam.repository.MoveRepository
import br.com.pokeapi.poketeam.util.GlobalConstants.Companion.SEARCH_ABILITY_TOPIC
import br.com.pokeapi.poketeam.util.GlobalConstants.Companion.SEARCH_MOVE_TOPIC
import br.com.pokeapi.poketeam.util.GlobalConstants.Companion.TEAM_NOT_FOUND_EXCEPTION
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class PokeTeamServiceImpl(
  val teamRepository: TeamRepository,
  val abilityRepository: AbilityRepository,
  val moveRepository: MoveRepository,
  val mapper: Mapper,
  val kafkaProducer: KafkaProducer
) : PokeTeamService {

  @Transactional
  override fun create(request: TeamDTORequest): TeamDTOResponse {
    val entity = mapper.teamRequestToEntity(request)

    entity.pokemonList.forEach { poke ->
      val abilityEntity = abilityRepository.findById(poke.ability.name)
      if (abilityEntity.isEmpty) {
        kafkaProducer.sendObjectMessage(Message(SEARCH_ABILITY_TOPIC, poke.ability.name, Instant.now()))
      } else {
        poke.ability = abilityEntity.get()
      }

      poke.moves.forEachIndexed { index, move ->
        val moveEntity = moveRepository.findById(move.name)
        if (moveEntity.isEmpty) {
          kafkaProducer.sendObjectMessage(Message(SEARCH_MOVE_TOPIC, move.name, Instant.now()))
        } else {
          entity.pokemonList[index].moves = listOf(moveEntity.get())
        }
      }
    }
    return mapper.teamEntityToResponse(teamRepository.save(entity))
  }

  @Transactional
  override fun getAll(): List<TeamDTOResponse> {
    return teamRepository.findAll().map { entity -> mapper.teamEntityToResponse(entity) }
  }

  @Transactional
  override fun getById(teamId: UUID): TeamDTOResponse {
    val entity = teamRepository.findById(teamId)
      .orElseThrow { TeamNotFoundException("$TEAM_NOT_FOUND_EXCEPTION$teamId") }

    return mapper.teamEntityToResponse(entity)
  }

  @Transactional
  override fun update(request: TeamDTORequest, teamId: UUID): TeamDTOResponse {
    val oldEntity = teamRepository.findById(teamId)
      .orElseThrow { TeamNotFoundException("$TEAM_NOT_FOUND_EXCEPTION$teamId") }

    val updatedEntity = mapper.teamUpdateFromRequest(oldEntity, request)

    updatedEntity.pokemonList.forEach { poke ->
      val abilityEntity = abilityRepository.findById(poke.ability.name)
      if (abilityEntity.isEmpty) {
        kafkaProducer.sendObjectMessage(Message(SEARCH_ABILITY_TOPIC, poke.ability.name, Instant.now()))
      } else {
        poke.ability = abilityEntity.get()
      }

      poke.moves.forEachIndexed { index, move ->
        val moveEntity = moveRepository.findById(move.name)
        if (moveEntity.isEmpty) {
          kafkaProducer.sendObjectMessage(Message(SEARCH_MOVE_TOPIC, move.name, Instant.now()))
        } else {
          updatedEntity.pokemonList[index].moves = listOf(moveEntity.get())
        }
      }
    }
    return mapper.teamEntityToResponse(teamRepository.save(updatedEntity))
  }

  @Transactional
  override fun delete(teamId: UUID) {
    if (!teamRepository.existsById(teamId)) {
      throw TeamNotFoundException("$TEAM_NOT_FOUND_EXCEPTION$teamId")
    }
    teamRepository.deleteById(teamId)
  }
}
