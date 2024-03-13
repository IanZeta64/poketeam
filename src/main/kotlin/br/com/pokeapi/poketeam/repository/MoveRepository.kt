package br.com.pokeapi.poketeam.repository

import br.com.pokeapi.poketeam.entity.Move
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface MoveRepository : JpaRepository<Move, String> {


}
