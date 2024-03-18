package br.com.fiap.medbusca.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    private val URL = "http://10.0.2.2:8080/"
    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getService(): Service {
        return retrofitFactory.create(Service::class.java)
    }
}