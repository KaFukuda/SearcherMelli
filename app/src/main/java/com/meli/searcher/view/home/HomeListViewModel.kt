package com.meli.searcher.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meli.searcher.model.ItemDetails
import com.meli.searcher.service.api.ItemsHomeService

class HomeListViewModel: ViewModel() {

    private val itemListHomeService = ItemsHomeService()
    private val mList = MutableLiveData<List<ItemDetails>>()

    val _mList: LiveData<List<ItemDetails>>
    get() {
        return mList
    }

    fun searchByWord( word: String ){
        mList.value = itemListHomeService.searchByWord(word)
    }
}