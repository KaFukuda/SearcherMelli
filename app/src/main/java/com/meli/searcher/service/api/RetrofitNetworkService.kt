package com.meli.searcher.service.api

import com.meli.searcher.env.API_BASE_URL
import com.meli.searcher.env.TOKEN
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitNetworkService {

    companion object {
        private lateinit var INSTANCE: Retrofit

        private fun getRetrofitInstance(): Retrofit {
            val http = OkHttpClient.Builder()
            // if the instance is not initialized then instantiate it
            if (!Companion::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }

        //connection
        fun createService(): EndpointsCoroutinesService {
            val getRetrofit = getRetrofitInstance().create(EndpointsCoroutinesService::class.java)
            try {
                return getRetrofit
            } catch (e: Exception) {
                println("NetworkUtils - CreateService: Error on call retrofit : $e")
            }
            return getRetrofit
        }

        fun getToken(): String {
            return "Bearer $TOKEN"
        }
    }
}


