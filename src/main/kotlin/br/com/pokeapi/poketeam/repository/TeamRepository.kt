package br.com.pokeapi.poketeam.repository

import br.com.pokeapi.poketeam.entity.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TeamRepository: JpaRepository<Team, UUID> {
}
