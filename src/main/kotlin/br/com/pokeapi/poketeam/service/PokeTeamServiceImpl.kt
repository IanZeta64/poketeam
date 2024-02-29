package br.com.pokeapi.poketeam.service

import br.com.pokeapi.poketeam.PokeTeamNotFoundException
import br.com.pokeapi.poketeam.repository.PokeTeamRepository
import br.com.pokeapi.poketeam.entity.PokeTeam
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.util.*

@Service
@RequiredArgsConstructor
class PokeTeamServiceImpl(val repository: PokeTeamRepository): PokeTeamService {
  override fun create(team: PokeTeam): PokeTeam {
    return repository.save(team)
  }

  override fun getAll(): List<PokeTeam> {
    return repository.findAll()
  }

  override fun getById(teamId: UUID): PokeTeam {
    return repository.findById(teamId)
      .orElseThrow { PokeTeamNotFoundException("Team not founded by id $teamId") }
  }

  override fun update(team: PokeTeam, teamId: UUID): PokeTeam {
    if(!repository.existsById(teamId)) {
      throw PokeTeamNotFoundException("Team not founded by id $teamId")
    }
     return repository.save(
       PokeTeam(teamId, team.trainer, team.sex,  team.region, team.pokeBattleList, team.spriteUrl))
  }

  override fun delete(teamId: UUID) {
    if(!repository.existsById(teamId)) {
      throw PokeTeamNotFoundException("Team not founded by id $teamId")
    }
    repository.deleteById(teamId)
  }

}
