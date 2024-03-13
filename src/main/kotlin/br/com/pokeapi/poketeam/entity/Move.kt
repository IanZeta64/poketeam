package br.com.pokeapi.poketeam.entity

import br.com.pokeapi.poketeam.enums.Effect
import br.com.pokeapi.poketeam.enums.Type
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="move")
data class Move(@Id
                val name: String,
                @Enumerated(EnumType.STRING)
                val type: Type?,
                @Enumerated(EnumType.STRING)
                val effect: Effect?,
                val damage: Int?,
                val pp: Int?,
                val accuracy: Int?,
                val priority: Int?,
                @Column(length = 2000)
                val description: String?) {
  constructor(name: String): this(name, null, null, null, null, null, null, null)

}
