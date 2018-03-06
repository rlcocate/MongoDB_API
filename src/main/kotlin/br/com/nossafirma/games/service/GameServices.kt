package br.com.nossafirma.games.service

import br.com.nossafirma.games.model.Game
import br.com.nossafirma.games.repository.GameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Service
class GameServices {

    // Injeção de dependência do Spring Boot. Late Init indica que o objeto vai inicializar depois.
    @Autowired
    lateinit var gameRepository: GameRepository

    fun BuscarTodos() : List<Game> {
        return gameRepository.findAll()
    }

    fun BuscarPorNome(@PathVariable(value = "titulo") titulo: String): List<Game> {
        return gameRepository.findByNomeIgnoreCaseContaining(nome = titulo)
    }
    fun salvar(game: Game){
        gameRepository.save(game)
    }

    fun excluir(id: String){
        gameRepository.deleteById(id)
    }

    fun excluirTodos(){
        gameRepository.deleteAll()
    }
}