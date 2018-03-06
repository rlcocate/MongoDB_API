package br.com.nossafirma.games.repository

import br.com.nossafirma.games.model.Game
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface GameRepository : MongoRepository<Game, String> {

    // Like e não é case sensitive.
    fun findByNomeIgnoreCaseContaining(nome: String) : List<Game>

}