package br.com.pokeapi.poketeam.util

class GlobalConstants {
  companion object {
    const val BUILD_POKEMON_TOPIC = "build_pokemon"
    const val SEARCH_ABILITY_TOPIC = "search_ability"
    const val SEARCH_MOVE_TOPIC = "search_move"
    const val GROUP_ID = "group-id"
    const val TEAM_NOT_FOUND_EXCEPTION = "Team not founded by id: "
    const val POKEMON_NOT_FOUND_EXCEPTION = "Pokemon not founded by id: "
    const val MOVE_NOT_FOUND_EXCEPTION = "Move not founded by id: "
    const val ABILITY_NOT_FOUND_EXCEPTION = "Ability not founded by id: "
    const val EXTERNAL_API_ABILITY_EXCEPTION = "Cant get ability: "
    const val EXTERNAL_API_MOVE_EXCEPTION = "Cant get move: "
    const val EXTERNAL_API_ABILITY_URL = "https://pokeapi.co/api/v2/ability/"
    const val EXTERNAL_API_MOVE_URL = "https://pokeapi.co/api/v2/move/"
  }
}
