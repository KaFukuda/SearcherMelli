package com.meli.searcher.service.api
import android.util.Log
import com.meli.searcher.model.ItemDetails
import com.meli.searcher.util.NetworkUtils

class ItemsHomeService {

    private val apiService = NetworkUtils.createService()
    private val token = NetworkUtils.getToken()

    suspend fun searchByWord(word: String): List<ItemDetails>?  {
        var itemList = emptyList<ItemDetails>()

        try {
            val preditorWord = apiService.getByEntryData(word).first()
            val highlightObj = apiService.getHighlights(preditorWord.category_id, token)
            val ids = highlightObj.content.filter {
                it.type == "ITEM"
            }.map {
                it.id
            }
            itemList = apiService.getItems(ids.joinToString()).map {
                it.body
                //retorna lista de obj do tipo itemList
            }
        } catch (e: Exception) {
            Log.e("ItemsHomeService", "searchByWord : ${e.toString()}")
            }
        return itemList
    }

}