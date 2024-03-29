package br.com.pokeapi.poketeam.repository

import br.com.pokeapi.poketeam.entity.PokeTeam
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PokeTeamRepository: JpaRepository<PokeTeam, UUID> {
}
