package br.com.pokeapi.poketeam.dto

import br.com.pokeapi.poketeam.entity.Ability
import br.com.pokeapi.poketeam.entity.Move
import java.util.*

data class PokemonDTOResponse(
  val id: UUID? = null,
  val dexNumber: Int,
  val name: String,
  val level: Int,
  val ability: Ability? = null,
  val primaryType: String? = null,
  val secondaryType: String? = null,
  val moves: List<Move>? = null,
  val nature: String
) {

}
