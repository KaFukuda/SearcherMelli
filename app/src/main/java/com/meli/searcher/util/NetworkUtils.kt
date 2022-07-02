package com.meli.searcher.util

import com.meli.searcher.service.api.Endpoint
import okhttp3.OkHttpClient
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
        fun createService(): Endpoint {
            return getRetrofitInstance().create(Endpoint::class.java)
        }

        //generics
        fun <S> createGService(data: Class<S>): S {
            return getRetrofitInstance().create(data)
        }

        fun getToken(): String{
            //atualiza qdo vencer
            return "Bearer APP_USR-2859167208567892-070215-68cbc8683c586c6d1dab46e575088278-250404804"
        }
    }

}
