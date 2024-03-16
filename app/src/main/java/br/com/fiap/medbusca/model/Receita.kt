package br.com.fiap.medbusca.model

data class Receita (
    val name : String = "",
    val medicine : String = "",
    val date : String = "",
    val dosage : String = "",
    val continuosUse : Boolean = false

)
