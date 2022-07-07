package com.meli.searcher.service.api

import android.util.Log
import com.meli.searcher.model.ItemDetailsModel
import retrofit2.HttpException

class CallsApiService {

    private val apiService = RetrofitNetworkService.createService()
    private val token = RetrofitNetworkService.getToken()

    suspend fun searchByWord(word: String): List<ItemDetailsModel> {
        var itemList: List<ItemDetailsModel> = emptyList()

        try {
            val predictorWord =
                apiService.getByEntryData(word).first()  //search by first word in SearchView

            val highlightObject =
                apiService.getHighlights(predictorWord.category_id, token) //search by category

            // verify by ITEM and returns an array
            val ids = highlightObject.content.filter {
                it.type == "ITEM"
            }.map {
                it.id
            }
            itemList = apiService.getItems(ids.joinToString()).map {
                it.body
            }
        } catch (e: Exception) {
            val throwable = Throwable()
            if (e is HttpException || throwable.equals(401))
                Log.e(
                    "ItemsHomeService",
                    "searchByWord: Error on call this instance,TOKEN is expired or empty: $e"
                )
        }
        return itemList
    }

    suspend fun getDetail(id: String): String {
        var detail = ""
        try {
            detail = apiService.getDetails(id).plain_text!!
        } catch (e: Exception) {
            val throwable = Throwable()
            if (e is HttpException || throwable.equals(401))
                Log.e(
                    "ItemsHomeService",
                    "getDetail: Error on call this instance,TOKEN is expired or empty: $e"
                )
        }
        return detail
    }
}