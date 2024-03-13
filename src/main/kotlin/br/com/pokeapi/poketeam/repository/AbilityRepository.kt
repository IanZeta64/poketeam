package br.com.pokeapi.poketeam.repository

import br.com.pokeapi.poketeam.entity.Ability
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AbilityRepository: JpaRepository<Ability, String> {

}
