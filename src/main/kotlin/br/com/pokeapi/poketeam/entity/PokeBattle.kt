package br.com.pokeapi.poketeam.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "pokebattle")
data class PokeBattle(@Id @GeneratedValue(strategy = GenerationType.UUID)
                      val id: UUID? = null,
                      val dexNumber: Int,
                      val name: String,
                      val level: Int,
//                      val ability: String,
//                      val types: List<String>,
//                      val moves: List<String>,
//                      val nature: String
){}

