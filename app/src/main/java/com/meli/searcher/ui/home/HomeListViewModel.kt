package com.meli.searcher.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meli.searcher.model.ItemDetailsModel
import com.meli.searcher.service.api.CallsApiService
import com.meli.searcher.util.Favorites
import kotlinx.coroutines.launch

class HomeListViewModel(context: Context
) : ViewModel() {

    private val itemListHomeService = CallsApiService()
    private val mList = MutableLiveData<List<ItemDetailsModel>>()
    private val favorites = Favorites(context)

    val liveDataMList: LiveData<List<ItemDetailsModel>>
    get() {
        return mList
    }

    fun searchByWord( word: String ){
        viewModelScope.launch {
            mList.value = itemListHomeService.searchByWord(word).onEach {
                it.is_favorite = favorites.getListOfFavorites().contains(it.id)
            }
        }
    }

    fun editFavorites(id : String){
        favorites.favoriteManager(id)
        verifyByIdFavoriteList()
    }

    fun verifyByIdFavoriteList(){
        mList.value = mList.value.apply {
            this?.forEach {
                it.is_favorite = favorites.getListOfFavorites().contains(it.id)
            }
        }
    }
}