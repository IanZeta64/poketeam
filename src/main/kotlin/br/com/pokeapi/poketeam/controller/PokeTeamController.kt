package br.com.pokeapi.poketeam.controller

import br.com.pokeapi.poketeam.dto.TeamDTORequest
import br.com.pokeapi.poketeam.dto.TeamDTOResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@RequestMapping("/v1/poketeam")
interface PokeTeamController {

  @GetMapping
  fun getAll(): ResponseEntity<List<TeamDTOResponse>>

  @GetMapping("/{teamId}")
  fun getById(@PathVariable teamId: UUID): ResponseEntity<TeamDTOResponse>

  @PostMapping
  fun create(@RequestBody team: TeamDTORequest): ResponseEntity<TeamDTOResponse>

  @PutMapping("/{teamId}")
  fun update(@PathVariable teamId: UUID, @RequestBody team: TeamDTORequest): ResponseEntity<TeamDTOResponse>

  @DeleteMapping("/{teamId}")
  fun delete(@PathVariable teamId: UUID): ResponseEntity<Unit>
}
