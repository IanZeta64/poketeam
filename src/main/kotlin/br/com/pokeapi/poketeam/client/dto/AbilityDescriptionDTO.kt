package br.com.pokeapi.poketeam.client.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AbilityDescriptionDTO(
  @JsonProperty("flavor_text_entries")
  val flavorTextEntries: List<FlavorTextEntry>,

)
data class FlavorTextEntry(
  @JsonProperty("flavor_text")
  val flavorText: String
)
