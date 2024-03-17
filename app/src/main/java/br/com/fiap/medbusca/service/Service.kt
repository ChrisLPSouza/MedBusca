package br.com.fiap.medbusca.service

import br.com.fiap.medbusca.model.Receita
import br.com.fiap.medbusca.model.Usuario
import retrofit2.Call
import retrofit2.http.GET

interface Service {

    fun doLogin() : Call<Usuario>


    @GET("/api/receita")
    fun getReceita() : Call<List<Receita>>
}