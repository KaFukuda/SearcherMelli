package com.meli.searcher.view.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meli.searcher.model.ItemDetails
import com.meli.searcher.service.api.ItemsHomeService
import com.meli.searcher.util.Favorites
import kotlinx.coroutines.launch

class HomeListViewModel(
    private val context: Context
) : ViewModel() {

    private val itemListHomeService = ItemsHomeService()
    private val mList = MutableLiveData<List<ItemDetails>>()
    private val favorites = Favorites(context)

    val _mList: LiveData<List<ItemDetails>>
    get() {
        return mList
    }

    fun searchByWord( word: String ){
        viewModelScope.launch {
            mList.value = itemListHomeService.searchByWord(word).apply {
                this.forEach {
                    it.is_favorite = favorites.getListFavs().contains(it.id)
                }
            }
        }
    }

    fun editFav(id : String){
        favorites.manageFavs(id)
        verifyFavs()
    }

    fun verifyFavs(){
        mList.value = mList.value.apply {
            this?.forEach {
                it.is_favorite = favorites.getListFavs().contains(it.id)
            }
        }
    }

}