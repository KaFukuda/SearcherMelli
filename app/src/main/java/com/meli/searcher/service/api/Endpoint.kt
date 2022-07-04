package com.meli.searcher.service.api

import com.meli.searcher.model.Details
import com.meli.searcher.model.DiscoveryCategory
import com.meli.searcher.model.HighlightsObject
import com.meli.searcher.model.ItemList
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface Endpoint {

    @GET("sites/MLB/domain_discovery/search?limit=2")
    suspend fun getByEntryData(
        @Query("q") q: String,
    ) : List<DiscoveryCategory>

    @GET("highlights/MLB/category/{id}")
    suspend fun getHighlights(
        @Path("id") id: String,
        @Header("Authorization") token: String = ""
    ) : HighlightsObject

    @GET("items")
    suspend fun getItems(
        @Query("ids") ids: String,
    ) : List<ItemList>

    @GET("items/{item_id}/description")
    suspend fun getDetails(
        @Path("item_id") itemId: String
    ) : Details

}