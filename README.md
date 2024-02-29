# POKETEAM BUILDER API

## Sobre

Em seus estágios iniciais, este projeto é um objeto de estudo para aprender os fundamentos do Kotlin. Atualmente, ele fornece um sistema de CRUD simples sem os recursos avançados de tratamento de erros, DTOs ou manipulação otimizada de dados.


## Planos Futuros

A ideia principal e conectar a outro microsserviço de criação de fakemons e registro de pokemons originais, dando a possibildiade de criar times mistos entre fakemons e pokemons. Sera um objetivo futuro, e sera conectada a minha outra api, que tambem esta em desenvolvimento: https://github.com/IanZeta64/PokeAPI

## Endpoints

### GET
* Endpoint:/v1/poketeam/

    - Retorna todos os times de Pokémon.

* Endpoint: /v1/poketeam/{teamId}

    - Retorna um time de Pokémon específico com base no ID(UUID) do time.

### POST 
* Endpoint: /v1/poketeam

    - Cria um time de pokemon baseado nas descrições contidas na sessão de Input.
    
### PUT
* Endpoint:  /v1/poketeam/{teamId}

    - Atualiza um time de Pokémon existente com base no ID(UUID) do time.

### DELETE
* Endpoint: /v1/poketeam/{teamId}

    - Remove um time de Pokémon com base no ID(UUID) do time.

 
## Input
{
  "trainer": "Ash Ketchum",
  "sex": "Male",
  "region": "Kanto",
  "pokeBattleList": [
    {
      "dexNumber": 25,
      "name": "Pikachu",
      "level": 50
    },
    {
      "dexNumber": 6,
      "name": "Charizard",
      "level": 55
    },
    {
      "dexNumber": 1,
      "name": "Bulbasaur",
      "level": 15
    }
  ],
  "spriteUrl": "https://example.com/ash-ketchum.png"
}

## Output
-Momentaneamente ainda e o mesmo do input. Logo sera atualizado.


