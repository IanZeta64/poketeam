package br.com.pokeapi.poketeam.service

import br.com.pokeapi.poketeam.client.ExternalAPIClient
import br.com.pokeapi.poketeam.entity.Ability
import br.com.pokeapi.poketeam.mapper.Mapper
import br.com.pokeapi.poketeam.message.Message
import br.com.pokeapi.poketeam.repository.AbilityRepository
import br.com.pokeapi.poketeam.repository.MoveRepository
import br.com.pokeapi.poketeam.util.GlobalConstants.Companion.GROUP_ID
import br.com.pokeapi.poketeam.util.GlobalConstants.Companion.SEARCH_ABILITY_TOPIC
import br.com.pokeapi.poketeam.util.GlobalConstants.Companion.SEARCH_MOVE_TOPIC
import jakarta.transaction.Transactional
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class PokemonBuilderServiceImpl(val abilityRepository: AbilityRepository,
                                val moveRepository: MoveRepository,
                                val client: ExternalAPIClient,
                                val mapper: Mapper): PokemonBuilderService {

  @KafkaListener(topics = [SEARCH_ABILITY_TOPIC], groupId = GROUP_ID)
  @Transactional
  override fun buildAbilityListener(message: Message){
    if(abilityRepository.existsById(message.content)){
      val description = client.getAbilityDescription(message.content)
      abilityRepository.save(Ability(message.content, description))
    }
  }

  @KafkaListener(topics = [SEARCH_MOVE_TOPIC], groupId = GROUP_ID)
  @Transactional
  override fun buildMoveListener(message: Message){
    if(moveRepository.existsById(message.content)){
      val dto = client.getMove(message.content)
      moveRepository.save( mapper.moveDTOtoEntity(message.content, dto))
    }
  }
}
