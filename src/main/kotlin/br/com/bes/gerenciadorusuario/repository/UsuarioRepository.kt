package br.com.bes.gerenciadorusuario.repository

import br.com.bes.gerenciadorusuario.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long>{


}