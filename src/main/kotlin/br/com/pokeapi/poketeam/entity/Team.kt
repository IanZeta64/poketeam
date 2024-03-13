package br.com.pokeapi.poketeam.entity

import jakarta.persistence.*
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "team")
data class Team(@Id @GeneratedValue(strategy = GenerationType.UUID)
                val id: UUID?,
                val trainer: String,
                val sex: String,
                val region: String,
                @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY) @JoinColumn(name = "team_id")
                val pokemonList: List<Pokemon>,
                val trainerSpriteUrl: String,
                val createdOn: Instant,
                var modifiedOn: Instant?) {
  constructor( trainer: String,
               sex: String,
               region: String,
               pokemonList: List<Pokemon>,
               trainerSpriteUrl: String,
               createdOn: Instant):
    this(null, trainer, sex, region, pokemonList, trainerSpriteUrl, createdOn, null)
}
