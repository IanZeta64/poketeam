package br.com.pokeapi.poketeam.entity

import br.com.pokeapi.poketeam.enums.Type
import jakarta.persistence.*
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "pokemon")
data class Pokemon(@Id @GeneratedValue(strategy = GenerationType.UUID)
                   val id: UUID?,
                   val dexNumber: Int,
                   val name: String,
                   val level: Int,
                   @ManyToOne(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY) @JoinColumn(name = "ability_id")
                   var ability: Ability,
                   @Enumerated(EnumType.STRING)
                   var types: List<Type>,
                   @ManyToMany(fetch = FetchType.LAZY)
                   @JoinTable(
                     name = "pokemon_moves",
                     joinColumns = [JoinColumn(name = "pokemon_id")],
                     inverseJoinColumns = [JoinColumn(name = "move_id")])
                   var moves: List<Move>,
                   val nature: String,
                   var pokeSpriteUrl: String,
                   val createdOn: Instant,
                   var modifiedOn: Instant?){
  constructor(
    dexNumber: Int,
    name: String,
    level: Int,
    ability: Ability,
    types: List<Type>,
    moves: List<Move>,
    nature: String,
    pokeSpriteUrl: String,
    createdOn: Instant): this(null, dexNumber, name, level, ability, types, moves, nature, pokeSpriteUrl, createdOn, null)
}

