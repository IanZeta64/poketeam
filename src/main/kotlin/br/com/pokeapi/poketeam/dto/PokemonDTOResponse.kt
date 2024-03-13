package br.com.pokeapi.poketeam.dto

import br.com.pokeapi.poketeam.entity.Ability
import br.com.pokeapi.poketeam.entity.Move
import java.util.*

data class PokemonDTOResponse(
  val id: UUID?,
  val dexNumber: Int,
  val name: String,
  val level: Int,
  val ability: Ability?,
  val primaryType: String?,
  val secondaryType: String?,
  val moves: List<Move>?,
  val nature: String,
  val pokeSpriteUrl: String?
) {

}
