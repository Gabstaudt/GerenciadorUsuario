package br.com.bes.gerenciadorusuario.controller

import br.com.bes.gerenciadorusuario.model.Usuario
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller // Indica que a classe vai ser um controller.

class UsuarioController {
    // Função que vai abrir formulario
    @GetMapping("/formulario/cadastro") // Recebe as requisições GET
    fun abrirFormularioCadastro(model: Model): String {

        // Cria objeto da classe Usuario vazio
        val usuario = Usuario()

        // Faz o envio objeto da classe de dados para o HTML
        model.addAttribute("usuarioNovo", usuario)
        return "formulario-cadastro"
    }

    // Função que vai receber o objeto de dados do HTML
    @PostMapping ("/cadastrar")
    fun cadastrarUsuario(): String{
        return "home"
    }
}
