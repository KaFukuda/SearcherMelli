package com.meli.searcher.service.api

import com.meli.searcher.model.DetailsModel
import com.meli.searcher.model.DiscoveryCategoryModel
import com.meli.searcher.model.HighlightsObjectModel
import com.meli.searcher.model.ItemListModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface EndpointsCoroutinesService {

    @GET("sites/MLB/domain_discovery/search")
    suspend fun getByEntryData(
        @Query("q") q: String,
        @Query("limit") limit : Int = 1
    ) : List<DiscoveryCategoryModel>

    @GET("highlights/MLB/category/{id}")
    suspend fun getHighlights(
        @Path("id") id: String,
        @Header("Authorization") token: String = ""
    ) : HighlightsObjectModel

    @GET("items")
    suspend fun getItems(
        @Query("ids") ids: String,
    ) : List<ItemListModel>

    @GET("items/{item_id}/description")
    suspend fun getDetails(
        @Path("item_id") itemId: String
    ) : DetailsModel

}