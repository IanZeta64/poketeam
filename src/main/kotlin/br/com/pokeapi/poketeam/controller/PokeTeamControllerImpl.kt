package br.com.pokeapi.poketeam.controller

import br.com.pokeapi.poketeam.entity.PokeTeam
import br.com.pokeapi.poketeam.service.PokeTeamService
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.*

@RestController
@RequiredArgsConstructor
class PokeTeamControllerImpl(val service: PokeTeamService): PokeTeamController {
  override fun getAll(): ResponseEntity<List<PokeTeam>> {
   return ResponseEntity.ok(service.getAll())
  }

  override fun getById(teamId: UUID): ResponseEntity<PokeTeam> {
    return ResponseEntity.ok(service.getById(teamId))
  }

  override fun create(team: PokeTeam): ResponseEntity<PokeTeam> {
    val createdTeam = service.create(team)
    return ResponseEntity.created(
      URI.create("/v1/poketeam/${createdTeam.id}")
    ).body(createdTeam)
  }

  override fun update(teamId: UUID, team: PokeTeam): ResponseEntity<PokeTeam> {
    val updatedTeam = service.update(team, teamId)
    return ResponseEntity.accepted().location(
      URI.create("/v1/poketeam/${updatedTeam.id}")
    ).body(updatedTeam)
  }

  override fun delete(teamId: UUID): ResponseEntity<Unit> {
    service.delete(teamId)
    return ResponseEntity.noContent().build();
  }
}
