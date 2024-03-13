package br.com.pokeapi.poketeam.client.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class MoveDTO(@JsonProperty("accuracy")
                   val accuracy: Int,
                   @JsonProperty("damage_class")
                   val effect: DamageClass,
                   @JsonProperty("effect_entries")
                   val description: List<EffectEntry>,
                   @JsonProperty("power")
                   val damage: Int,
                   @JsonProperty("pp")
                   val pp: Int,
                   @JsonProperty("priority")
                   val priority: Int,
                   @JsonProperty("type")
                   val type: TypeName){
}

data class DamageClass(@JsonProperty("name") val name: String){}
data class TypeName(@JsonProperty("name") val name: String){}

data class EffectEntry(@JsonProperty("effect") val effect: String){}

