package com.meli.searcher.util

import com.meli.searcher.env.TOKEN
import com.meli.searcher.service.api.EndpointsServiceCoroutines
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {
    //utilitário para instanciar o retrofit
    companion object {
        private lateinit var INSTANCE: Retrofit
        private const val API_BASE_URL = "https://api.mercadolibre.com/"

        private fun getRetrofitInstance(): Retrofit {
            val http = OkHttpClient.Builder()
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }

        //conexao
        fun createService(): EndpointsServiceCoroutines {
            val response : String
            val getRetrofit = getRetrofitInstance().create(EndpointsServiceCoroutines::class.java)
            try {
                return getRetrofit
            } catch (e: Exception) {
                println("CreateService: Erro na chamada da instancia retrofit : $e")
            }
            return getRetrofit
        }

        fun getToken(): String {
            when {
                TOKEN == "" -> println("getToken: String TOKEN vazia")
                else -> return "Bearer $TOKEN"
            }
            return "Bearer $TOKEN"
        }

    }

}
