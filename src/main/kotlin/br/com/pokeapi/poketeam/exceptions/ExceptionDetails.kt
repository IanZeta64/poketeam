package br.com.pokeapi.poketeam.exceptions

data class ExceptionDetails(
  var title: String? = null,
  var timestamp: String,
  var status: Int,
  var details: String?,
  var developerMethod: String
)
