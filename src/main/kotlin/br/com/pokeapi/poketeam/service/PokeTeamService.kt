package br.com.pokeapi.poketeam.service

import br.com.pokeapi.poketeam.entity.PokeTeam
import java.util.UUID

interface PokeTeamService {
  fun create(team: PokeTeam): PokeTeam
  fun getAll(): List<PokeTeam>
  fun getById(teamId: UUID): PokeTeam
  fun update(team: PokeTeam, teamId: UUID): PokeTeam
  fun delete(teamId: UUID)
}
