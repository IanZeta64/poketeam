package br.com.pokeapi.poketeam.message

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProducer(
  private val kafkaTemplate: KafkaTemplate<String, Message>
) {

  fun sendObjectMessage(message: Message) {
    kafkaTemplate.send(message.topic, message)
  }
}
