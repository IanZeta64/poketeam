package br.com.pokeapi.poketeam.service

import br.com.pokeapi.poketeam.dto.TeamDTORequest
import br.com.pokeapi.poketeam.dto.TeamDTOResponse
import java.util.UUID

interface PokeTeamService {
  fun create(request: TeamDTORequest): TeamDTOResponse
  fun getAll(): List<TeamDTOResponse>
  fun getById(teamId: UUID): TeamDTOResponse
  fun update(request: TeamDTORequest, teamId: UUID): TeamDTOResponse
  fun delete(teamId: UUID)
}
