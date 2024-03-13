package br.com.pokeapi.poketeam.client

import br.com.pokeapi.poketeam.client.dto.AbilityDescriptionDTO
import br.com.pokeapi.poketeam.client.dto.MoveDTO
import br.com.pokeapi.poketeam.exceptions.ExternalAPICommunicationException
import br.com.pokeapi.poketeam.util.GlobalConstants
import br.com.pokeapi.poketeam.util.GlobalConstants.Companion.EXTERNAL_API_ABILITY_EXCEPTION
import br.com.pokeapi.poketeam.util.GlobalConstants.Companion.EXTERNAL_API_ABILITY_URL
import br.com.pokeapi.poketeam.util.GlobalConstants.Companion.EXTERNAL_API_MOVE_EXCEPTION
import br.com.pokeapi.poketeam.util.GlobalConstants.Companion.EXTERNAL_API_MOVE_URL
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class ExternalAPIClient(private val restTemplate: RestTemplate) {

  fun getAbilityDescription(name: String): String {
    val url = "$EXTERNAL_API_ABILITY_URL${name.lowercase().replace(" ","-").trim()}"
    return restTemplate.getForObject(url, AbilityDescriptionDTO::class.java)?.
    flavorTextEntries?.get(1)?.flavorText
      ?: throw ExternalAPICommunicationException("$EXTERNAL_API_ABILITY_EXCEPTION$name")
  }

  fun getMove(name: String): MoveDTO {
    val url = "$EXTERNAL_API_MOVE_URL${name.lowercase().replace(" ","-").trim()}"
    return restTemplate.getForObject(url, MoveDTO::class.java)
      ?: throw ExternalAPICommunicationException("$EXTERNAL_API_MOVE_EXCEPTION$name")
  }
}
