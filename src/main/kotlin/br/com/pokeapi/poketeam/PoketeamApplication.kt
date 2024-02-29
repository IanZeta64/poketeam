package br.com.pokeapi.poketeam

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PoketeamApplication

fun main(args: Array<String>) {
	runApplication<PoketeamApplication>(*args)
}
