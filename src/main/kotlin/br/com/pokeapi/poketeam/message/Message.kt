package br.com.pokeapi.poketeam.message

import lombok.ToString
import java.io.Serializable
import java.time.Instant

@ToString
 class Message(val topic: String, val content: String, val timestamp: Instant): Serializable

