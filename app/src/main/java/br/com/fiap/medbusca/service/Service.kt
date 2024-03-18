package br.com.fiap.medbusca.service

import br.com.fiap.medbusca.model.Receita
import br.com.fiap.medbusca.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP

interface Service {
    //@GET("/api/usuario/login")
    @HTTP(method = "POST", path = "/api/usuario/login", hasBody = true)
    fun doLogin(@Body usuario: Usuario) : Call<Usuario>


    @GET("/api/receita")
    fun getReceita() : Call<List<Receita>>

}