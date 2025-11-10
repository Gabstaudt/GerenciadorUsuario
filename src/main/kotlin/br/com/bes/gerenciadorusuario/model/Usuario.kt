package br.com.bes.gerenciadorusuario.model

data class Usuario (
    val nome: String = "",
    val email: String = "",
    val cpf: String = "",
    val senha: String = "",
    val funcao: String = ""
){
}