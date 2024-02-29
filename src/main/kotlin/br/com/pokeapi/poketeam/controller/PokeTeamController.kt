package br.com.pokeapi.poketeam.controller

import br.com.pokeapi.poketeam.entity.PokeTeam
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
  fun getAll(): ResponseEntity<List<PokeTeam>>

  @GetMapping("/{teamId}")
  fun getById(@PathVariable teamId: UUID): ResponseEntity<PokeTeam>

  @PostMapping
  fun create(@RequestBody team: PokeTeam): ResponseEntity<PokeTeam>

  @PutMapping("/{teamId}")
  fun update(@PathVariable teamId: UUID, @RequestBody team: PokeTeam): ResponseEntity<PokeTeam>

  @DeleteMapping("/{teamId}")
  fun delete(@PathVariable teamId: UUID): ResponseEntity<Unit>
}
