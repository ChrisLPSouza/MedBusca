package br.com.fiap.medbusca.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    //USANDO SIMULADOR
    //private val URL = "http://10.0.2.2:8080/"

    // USANDO CELULAR FISICO
    // IP DA MAQUINA ou LOCALHOST
    private val URL = "http://localhost:8080/"
    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getService(): Service {
        return retrofitFactory.create(Service::class.java)
    }
}