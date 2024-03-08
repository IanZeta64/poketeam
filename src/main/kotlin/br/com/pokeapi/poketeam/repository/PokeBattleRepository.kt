package br.com.pokeapi.poketeam.repository

import br.com.pokeapi.poketeam.entity.Pokemon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PokeBattleRepository: JpaRepository<Pokemon, UUID> {
}
