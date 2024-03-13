package br.com.pokeapi.poketeam.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name="ability")
data class Ability(@Id
                   val name: String,
                   @Column(length = 1000)
                   var description: String?) {
  constructor(name: String): this( name, null)

}
