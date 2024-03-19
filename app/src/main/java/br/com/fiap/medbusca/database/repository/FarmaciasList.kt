package br.com.fiap.medbusca.database.repository

import br.com.fiap.medbusca.model.Farmacia

fun getAllFarmacias(): List<Farmacia>{

        return listOf(
        Farmacia(id = 1, nomeFarmacia = "UBS Santa Inês", endereco = "Rua Minduri 1077 " +
                "Bairro Santa Inês", listaMedicamentos = listOf("paracetamol", "ibuprofeno", "levotiroxina"), horarioFuncionamento = "De Segunda a sábado : 8h - 19h"),
            Farmacia(id = 2, nomeFarmacia =
            "Farmácia do Povo", endereco =
            "Avenida Brasil" +
                    " 150 Bairro Santa Tereza",
                listaMedicamentos = listOf("paracetamol", "ibuprofeno", "levotiroxina", "dipirona", "amoxicilina"), horarioFuncionamento = "Todos os dias : 9h - 22h"),
            Farmacia(id = 3, nomeFarmacia =
            "Droga Raia", endereco =
            "Avenida Brasil" +
                    " 1002 Bairro Santa Tereza",
                listaMedicamentos = listOf("paracetamol", "ibuprofeno", "dipirona", "amoxicilina"), horarioFuncionamento = "De Segunda a sábado : 8h - 19h"),
            Farmacia(id = 4, nomeFarmacia =
            "Drogasil", endereco =
            "Avenida do Contorno" +
                    " 7 Centro",
                listaMedicamentos = listOf("paracetamol", "ibuprofeno", "dipirona", "amoxicilina"), horarioFuncionamento = "Todos os dias : 24h"),
            Farmacia(id = 5, nomeFarmacia =
            "UBS Centro-Oeste", endereco =
            "Avenida Tereza Cristina" +
                    " 104 Centro",
                listaMedicamentos = listOf("paracetamol", "ibuprofeno", "dipirona", "amoxicilina", "levotiroxina"), horarioFuncionamento = "De Segunda a sábado : 8h - 19h"),
            Farmacia(id = 6, nomeFarmacia =
            "Farmácia do Trabalhador", endereco =
            "Avenida Primeiro de Maio" +
                    " 222 Centro",
                listaMedicamentos = listOf("paracetamol", "ibuprofeno", "dipirona", "amoxicilina", "lítio"), horarioFuncionamento = "De Segunda a sábado : 8h - 19h"),
    )
}

fun getFarmaciasPorMedicamento(medicamento: String): List<Farmacia>{
    return getAllFarmacias().filter{
        it.listaMedicamentos.contains(medicamento)
    }
}