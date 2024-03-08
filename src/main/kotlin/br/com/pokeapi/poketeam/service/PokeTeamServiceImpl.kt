package br.com.pokeapi.poketeam.service

import br.com.pokeapi.poketeam.exceptions.PokeTeamNotFoundException
import br.com.pokeapi.poketeam.dto.TeamDTORequest
import br.com.pokeapi.poketeam.dto.TeamDTOResponse
import br.com.pokeapi.poketeam.repository.PokeTeamRepository
import br.com.pokeapi.poketeam.entity.Team
import br.com.pokeapi.poketeam.mapper.Mapper
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
@RequiredArgsConstructor
class PokeTeamServiceImpl(val repository: PokeTeamRepository, val mapper: Mapper): PokeTeamService {
  override fun create(request: TeamDTORequest): TeamDTOResponse {
    val entity = repository.save(mapper.teamRequestToEntity(request))
    return mapper.teamEntityToResponse(entity)
  }

  override fun getAll(): List<TeamDTOResponse> {
    return repository.findAll().map { entity -> mapper.teamEntityToResponse(entity) }
  }

  override fun getById(teamId: UUID): TeamDTOResponse {
    val entity = repository.findById(teamId)
      .orElseThrow { PokeTeamNotFoundException("Team not founded by id $teamId") }
    return mapper.teamEntityToResponse(entity)
  }

  override fun update(request: TeamDTORequest, teamId: UUID): TeamDTOResponse {
    val oldEntity = repository.findById(teamId)
      .orElseThrow { PokeTeamNotFoundException("Team not founded by id $teamId") }
    val updatedEntity =  repository.save(
       Team(oldEntity.id, request.trainer, request.sex,  request.region,
         request.pokemonList.map { poke -> mapper.pokemonRequestToEntity(poke) },
         request.trainerSpriteUrl, oldEntity.createdOn, Instant.now())
    )
    return mapper.teamEntityToResponse(updatedEntity)
  }

  override fun delete(teamId: UUID) {
    if(!repository.existsById(teamId)) {
      throw PokeTeamNotFoundException("Team not founded by id $teamId")
    }
    repository.deleteById(teamId)
  }

}
