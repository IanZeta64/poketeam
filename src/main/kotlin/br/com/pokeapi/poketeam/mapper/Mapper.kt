package br.com.pokeapi.poketeam.mapper

import br.com.pokeapi.poketeam.dto.PokemonDTORequest
import br.com.pokeapi.poketeam.dto.PokemonDTOResponse
import br.com.pokeapi.poketeam.dto.TeamDTORequest
import br.com.pokeapi.poketeam.dto.TeamDTOResponse
import br.com.pokeapi.poketeam.entity.*
import br.com.pokeapi.poketeam.enums.Type
import org.springframework.context.annotation.Configuration
import java.time.Instant

@Configuration
class Mapper {
  fun teamRequestToEntity(request: TeamDTORequest): Team{
    return Team(request.trainer, request.sex, request.region,
      request.pokemonList.map { pokemon -> pokemonRequestToEntity(pokemon) },
      request.trainerSpriteUrl, Instant.now())
  }
  fun teamEntityToResponse(entity: Team): TeamDTOResponse{
    return TeamDTOResponse(entity.id, entity.trainer, entity.sex, entity.region,
      entity.pokemonList.map { pokemon -> pokemonEntityToResponse(pokemon) },
      entity.trainerSpriteUrl)
  }

  fun pokemonRequestToEntity(request: PokemonDTORequest): Pokemon{
    val types = mutableListOf<Type>()
    types.add(Type.valueOf(request.primaryType))
    request.secondaryType?.let {
      types.add(Type.valueOf(it))
    }
    return Pokemon(request.dexNumber, request.name, request.level,
      Ability(request.ability), types,
      request.moves.map { name-> Move(name) }, request.nature, Instant.now())
  }

  private fun pokemonEntityToResponse(entity: Pokemon): PokemonDTOResponse{
    val primaryType = entity.types[0].toString()
    var secondaryType: String?= null
    if(entity.types.size > 1)
      secondaryType = entity.types[1].toString()
    return PokemonDTOResponse(entity.id, entity.dexNumber, entity.name, entity.level, entity.ability,
      primaryType, secondaryType, entity.moves, entity.nature)
  }
}
