package br.com.bes.gerenciadorusuario.controller

import br.com.bes.gerenciadorusuario.model.Usuario
import br.com.bes.gerenciadorusuario.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ModelAttribute

@Controller
class UsuarioController {

    @Autowired
    lateinit var repositorio: UsuarioRepository

    // FORM CADASTRO (GET)
    @GetMapping("/formulario/cadastro")
    fun abrirFormularioCadastro(model: Model): String {
        val usuario = Usuario()
        model.addAttribute("usuarioNovo", usuario)
        return "formulario-cadastro"
    }

    // CADASTRAR (POST)
    @PostMapping("/cadastrar")
    fun cadastrarUsuario(@ModelAttribute("usuarioNovo") usuario: Usuario): String {
        println(usuario)
        repositorio.save(usuario)
        return "redirect:/home"
    }

    // HOME (LISTAGEM)
    @GetMapping("/home")
    fun abrirHome(model: Model): String {
        val usuarios = repositorio.findAll()
        model.addAttribute("usuarios", usuarios)
        return "home"
    }

    // EXCLUIR
    @GetMapping("/excluir/{id}")
    fun excluirUsuario(@PathVariable("id") id: Long): String {
        repositorio.deleteById(id)
        return "redirect:/home"
    }

    @GetMapping("/formulario/edicao/{id}")
    fun abrirFormularioEdicao(@PathVariable("id") id: Long, model: Model): String {
        val usuario = repositorio.findById(id).orElse(null)

        if (usuario == null) {
            return "redirect:/home"
        }

        model.addAttribute("usuarioEdit", usuario)
        return "formulario-edicao"
    }

    @PostMapping("/editar")
    fun editarUsuario(@ModelAttribute("usuarioEdit") usuario: Usuario): String {
        repositorio.save(usuario)
        return "redirect:/home"
    }

}
