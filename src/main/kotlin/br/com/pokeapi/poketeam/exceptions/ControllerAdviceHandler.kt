package br.com.pokeapi.poketeam.exceptions

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.lang.Nullable
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.Instant


@ControllerAdvice
class ControllerAdviceHandler: ResponseEntityExceptionHandler() {

  override fun handleExceptionInternal(
    ex: Exception,
    @Nullable body: Any?,
    headers: HttpHeaders,
    statusCode: HttpStatusCode,
    request: WebRequest
  ): ResponseEntity<Any>? {
    val errorDetails = ExceptionDetails(
      title = ex.cause?.message,
      timestamp = Instant.now().toString(),
      status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
      details = ex.message,
      developerMethod = ex.javaClass.getName()
    )
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails)
  }

  @ExceptionHandler(TeamNotFoundException::class)
  fun handleClientNotFoundException(ex: TeamNotFoundException, request: WebRequest): ResponseEntity<Any> {
    val errorDetails = ExceptionDetails(
      title = "Poke team not found",
      timestamp = Instant.now().toString(),
      status = HttpStatus.NOT_FOUND.value(),
      details = ex.message,
      developerMethod = ex.javaClass.name
    )
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails)
  }

  @ExceptionHandler(PokemonNotFoundException::class)
  fun handlePokemonNotFoundException(ex: PokemonNotFoundException, request: WebRequest): ResponseEntity<Any> {
    val errorDetails = ExceptionDetails(
      title = "Pokemon not found",
      timestamp = Instant.now().toString(),
      status = HttpStatus.NOT_FOUND.value(),
      details = ex.message,
      developerMethod = ex.javaClass.name
    )
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails)
  }

  @ExceptionHandler(AbilityNotFoundException::class)
  fun handleAbilityNotFoundException(ex: AbilityNotFoundException, request: WebRequest): ResponseEntity<Any> {
    val errorDetails = ExceptionDetails(
      title = "Ability not found",
      timestamp = Instant.now().toString(),
      status = HttpStatus.NOT_FOUND.value(),
      details = ex.message,
      developerMethod = ex.javaClass.name
    )
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails)
  }

  @ExceptionHandler(MoveNotFoundException::class)
  fun handleMoveNotFoundException(ex: MoveNotFoundException, request: WebRequest): ResponseEntity<Any> {
    val errorDetails = ExceptionDetails(
      title = "Move not found",
      timestamp = Instant.now().toString(),
      status = HttpStatus.NOT_FOUND.value(),
      details = ex.message,
      developerMethod = ex.javaClass.name
    )
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails)
  }

  @ExceptionHandler(ExternalAPICommunicationException::class)
  fun handleMoveNotFoundException(ex: ExternalAPICommunicationException, request: WebRequest): ResponseEntity<Any> {
    val errorDetails = ExceptionDetails(
      title = "External API communication failed",
      timestamp = Instant.now().toString(),
      status = HttpStatus.BAD_GATEWAY.value(),
      details = ex.message,
      developerMethod = ex.javaClass.name
    )
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(errorDetails)
  }

}
