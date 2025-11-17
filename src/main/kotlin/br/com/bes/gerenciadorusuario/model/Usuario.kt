package br.com.bes.gerenciadorusuario.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


//Informar a spring que essa classe vai ser uma tabela no bd
@Entity
data class Usuario (
    //Definir um identificador para a tabela e a chave primária com auto increment

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val nome: String = "",
    val email: String = "",
    val cpf: String = "",
    val senha: String = "",
    val funcao: String = "",
    val idade: String = ""
){
}