package br.com.pokeapi.poketeam.message.config

import br.com.pokeapi.poketeam.message.Message
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ContainerProperties
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class KafkaConsumerConfig {

  @Bean
  fun consumerFactory(): ConsumerFactory<String, Message> {
    val props = mutableMapOf<String, Any>()
    props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
    props[ConsumerConfig.GROUP_ID_CONFIG] = "group-id"
    props[ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG] = "30000"
    props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = ErrorHandlingDeserializer::class.java
    props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = ErrorHandlingDeserializer::class.java
    props[JsonDeserializer.TRUSTED_PACKAGES] = "*"

    return DefaultKafkaConsumerFactory(props, StringDeserializer(), JsonDeserializer(Message::class.java, false))
  }

  @Bean
  fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, Message> {
    val factory = ConcurrentKafkaListenerContainerFactory<String, Message>()
    factory.consumerFactory = consumerFactory()
    factory.containerProperties.ackMode = ContainerProperties.AckMode.RECORD
    return factory
  }
}
