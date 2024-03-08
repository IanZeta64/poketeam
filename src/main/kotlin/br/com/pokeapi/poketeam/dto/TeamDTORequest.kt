package br.com.pokeapi.poketeam.dto


data class TeamDTORequest(val trainer: String,
                     val sex: String,
                     val region: String,
                     val pokemonList: List<PokemonDTORequest>,
                     val trainerSpriteUrl: String) {
}
