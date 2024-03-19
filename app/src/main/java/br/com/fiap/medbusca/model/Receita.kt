package br.com.fiap.medbusca.model

data class Receita (

    val id : Int,
    val receita : String,
    val medicamento : String,
    val data : String,
    val posologia : String,
    val usoContinuo : Boolean
)

