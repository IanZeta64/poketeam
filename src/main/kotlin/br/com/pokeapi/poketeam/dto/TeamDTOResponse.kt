package br.com.pokeapi.poketeam.dto

import java.util.*

data class TeamDTOResponse(
  val id: UUID? = null,
  val trainer: String,
  val sex: String,
  val region: String,
  val pokemonList: List<PokemonDTOResponse>,
  val trainerSpriteUrl: String) {
}
