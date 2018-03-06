package br.com.nossafirma.games.controller

import br.com.nossafirma.games.model.Game
import br.com.nossafirma.games.service.GameServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin // Resolve o problema de segurança do browser que poderia bloquear o acesso.
@RequestMapping(value="/games")
class GameController{

    @Autowired
    lateinit var gameService: GameServices;

    @GetMapping
    fun BuscarTodos(): List<Game>{
        return gameService.BuscarTodos();
    }

    @GetMapping(value="/titulo/{titulo}")
    fun BuscarTodosPorTitulo(@PathVariable(value = "titulo") titulo: String) : List<Game>{
        return gameService.BuscarPorNome(titulo)
    }

    @PostMapping
    fun Salvar(@RequestBody game: Game){
        gameService.salvar(game)
    }

    @DeleteMapping("{id}")
    fun Excluir(@PathVariable("id") id: String){
        gameService.excluir(id)
    }

    @DeleteMapping
    fun Excluir(){
        gameService.excluirTodos()
    }
}

