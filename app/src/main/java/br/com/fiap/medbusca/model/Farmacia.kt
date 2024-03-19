package br.com.fiap.medbusca.model

data class Farmacia (
    val id : Int = 0,
    val nomeFarmacia : String = "",
    val endereco : String  = "",
    val listaMedicamentos: List<String>,
    val horarioFuncionamento: String
)
