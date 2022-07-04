package com.meli.searcher.service.api
import android.util.Log
import com.meli.searcher.model.ItemDetails
import com.meli.searcher.util.NetworkUtils

class ItemsHomeService {

    private val apiService = NetworkUtils.createService()
    private val token = NetworkUtils.getToken()

    suspend fun searchByWord(word: String): List<ItemDetails>  {
        var itemList: List<ItemDetails> = emptyList<ItemDetails>()

        try {
            //pesquisa pela 1a palavra do SearchView
            val preditorWord = apiService.getByEntryData(word).first()

            //pesquisa por categoria
            val highlightObj = apiService.getHighlights(preditorWord.category_id, token)

            //valida por tipo ITEM e itera em um array
            val ids = highlightObj.content.filter {
                it.type == "ITEM"
            }.map {
                it.id
            }
            itemList = apiService.getItems(ids.joinToString()).map {
                it.body

                //retorna lista de obj do tipo itemList
            }

            //pesquisa detalhe por id
            itemList.forEach {
                it.plain_text = apiService.getDetails(it.id!!).plain_text
            }


        } catch (e: Exception) {
            Log.e("ItemsHomeService", "searchByWord : $e")
            }
        return itemList
    }

    //suspend fun getFavorites(){

    //}

}