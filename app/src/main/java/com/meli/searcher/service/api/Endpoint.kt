package com.meli.searcher.service.api

import com.google.gson.JsonObject
import com.meli.searcher.model.DiscoveryCategory
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {

    @GET("https://api.mercadolibre.com/sites/MLB/domain_discovery/search?limit=5&q=Carros")
    fun getByEntryData(
        //@Query("q") q: String,
    ) : Call<MutableList<DiscoveryCategory>>



    companion object {

        //1 - chamada - traz os 10 primeiros por categoria
        const val API_DISCOVERY_PREDICTOR =  "https://api.mercadolibre.com/sites/MLB/domain_discovery/search?limit=1&"

        //2 - chamada - traz os 20 mais vendidos se a categoria existir
        const val API_HIGHLIGHTS = "https://api.mercadolibre.com/highlights/MLB/category"

        //3 - chamada - traz somente Itens separados por virgula e seus detalhes
        const val API_MULTIGETS_DETAILS = "https://api.mercadolibre.com/items?"

    }
}