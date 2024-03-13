package br.com.pokeapi.poketeam.dto

data class PokemonDTORequest(
  val dexNumber: Int,
  val name: String,
  val level: Int,
  val ability: String,
  val primaryType: String,
  val secondaryType: String?= null,
  val moves: List<String>,
  val nature: String,
  val pokeSpriteUrl: String
) {
}
