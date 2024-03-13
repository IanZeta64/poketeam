package br.com.pokeapi.poketeam.controller

import br.com.pokeapi.poketeam.dto.TeamDTORequest
import br.com.pokeapi.poketeam.dto.TeamDTOResponse
import br.com.pokeapi.poketeam.service.PokeTeamService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.*

@RestController
class PokeTeamControllerImpl(val service: PokeTeamService): PokeTeamController {
  override fun getAll(): ResponseEntity<List<TeamDTOResponse>> {
   return ResponseEntity.ok(service.getAll())
  }

  override fun getById(teamId: UUID): ResponseEntity<TeamDTOResponse> {
    return ResponseEntity.ok(service.getById(teamId))
  }

  override fun create(team: TeamDTORequest): ResponseEntity<TeamDTOResponse> {
    val createdTeam = service.create(team)
    return ResponseEntity.created(
      URI.create("/v1/poketeam/${createdTeam.id}")
    ).body(createdTeam)
  }

  override fun update(teamId: UUID, team: TeamDTORequest): ResponseEntity<TeamDTOResponse> {
    val updatedTeam = service.update(team, teamId)
    return ResponseEntity.accepted().location(
      URI.create("/v1/poketeam/${updatedTeam.id}")
    ).body(updatedTeam)
  }

  override fun delete(teamId: UUID): ResponseEntity<Unit> {
    service.delete(teamId)
    return ResponseEntity.noContent().build()
  }
}
