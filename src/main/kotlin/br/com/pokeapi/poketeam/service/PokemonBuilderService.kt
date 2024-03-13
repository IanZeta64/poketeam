package br.com.pokeapi.poketeam.service

import br.com.pokeapi.poketeam.message.Message


interface PokemonBuilderService {
  fun buildAbilityListener(message: Message)

  fun buildMoveListener(message: Message)
}

