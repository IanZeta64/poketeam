package br.com.pokeapi.poketeam.entity

import br.com.pokeapi.poketeam.enums.Type
import jakarta.persistence.*
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "pokemon")
data class Pokemon(@Id @GeneratedValue(strategy = GenerationType.UUID)
                   val id: UUID? = null,
                   val dexNumber: Int,
                   val name: String,
                   val level: Int,
                   @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY) @JoinColumn(name = "pokemon_id")
                   var ability: Ability? = null,
                   @Enumerated(EnumType.STRING)
                   var types: List<Type>,
                   @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY) @JoinColumn(name = "pokemon_id")
                   var moves: List<Move>,
                   val nature: String,
                   val createdOn: Instant,
                   var modifiedOn: Instant? = null ){
  constructor(
    dexNumber: Int,
    name: String,
    level: Int,
    ability: Ability,
    types: List<Type>,
    moves: List<Move>,
    nature: String,
    createdOn: Instant): this(null, dexNumber, name, level, ability, types, moves, nature, createdOn, null)
}

