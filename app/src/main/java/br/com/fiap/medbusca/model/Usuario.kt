package br.com.fiap.medbusca.model

data class Usuario (
    val id : Int,
    val email : String,
    val senha: String
)

fun Usuario.toString(): String {
    return "ID:$id - EMAIL:$email - SENHA:$senha"
}


