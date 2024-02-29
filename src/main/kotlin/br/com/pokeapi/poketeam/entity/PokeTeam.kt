package br.com.pokeapi.poketeam.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "poketeam")
data class PokeTeam(@Id @GeneratedValue(strategy = GenerationType.UUID)
                    val id: UUID? = null,
                    val trainer: String,
                    val sex: String,
                    val region: String,
                    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY) @JoinColumn(name = "poketeam_id")
                    val pokeBattleList: List<PokeBattle>,
                    val spriteUrl: String) {
}
