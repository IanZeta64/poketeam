package br.com.pokeapi.poketeam.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name="ability")
data class Ability(@Id @GeneratedValue(strategy = GenerationType.UUID)
                   @JsonIgnore
                   val id: UUID? = null,
                   val name: String,
                   var description: String? = null) {
  constructor(name: String): this(null, name, null)

}
