package com.meli.searcher.service.api
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import com.meli.searcher.model.ItemDetails
import com.meli.searcher.util.NetworkUtils
import retrofit2.HttpException


class ItemsHomeService {

    private val apiService = NetworkUtils.createService()
    private val token = NetworkUtils.getToken()

    suspend fun searchByWord(word: String): List<ItemDetails>  {
        var itemList: List<ItemDetails> = emptyList()

        try {
            val predictorWord = apiService.getByEntryData(word).first()  //search by first word in SearchView
            val highlightObj = apiService.getHighlights(predictorWord.category_id, token) //search by category

            // verify by ITEM and returns an array
            val ids = highlightObj.content.filter {
                it.type == "ITEM"
            }.map {
                it.id
            }
            itemList = apiService.getItems(ids.joinToString()).map {
                it.body
            }
            //search detail by id
            itemList.forEach {
                it.plain_text = apiService.getDetails(it.id!!).plain_text
            }
        } catch (e: Exception) {
            val throwable = Throwable()
                if (e !is HttpException && !throwable.equals(401)) {
                } else
                    Log.e("ItemsHomeService", "CreateService: Error on call to retrofit instance, TOKEN is expired: $e")
        }
        return itemList
    }
}