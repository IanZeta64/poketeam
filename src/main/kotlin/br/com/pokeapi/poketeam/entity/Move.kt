package br.com.pokeapi.poketeam.entity

import br.com.pokeapi.poketeam.enums.Effect
import br.com.pokeapi.poketeam.enums.Type
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="move")
data class Move(@Id @GeneratedValue(strategy = GenerationType.UUID)
                @JsonIgnore
                val id: UUID? = null,
                val name: String,
                @Enumerated(EnumType.STRING)
                val type: Type? = null,
                @Enumerated(EnumType.STRING)
                val effect: Effect? = null,
                val damage: Int? = null,
                val pp: Int? = null,
                val priority: Boolean? = null,
                val description: String? = null) {
  constructor(name: String): this( null, name, null, null, null, null, null, null)

}
