package com.meli.searcher.ui.products

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meli.searcher.model.ItemDetailsModel
import com.meli.searcher.service.api.CallsApiService
import com.meli.searcher.util.Favorites
import kotlinx.coroutines.launch

class ProductDetailsViewModel(
    context: Context
): ViewModel() {
    lateinit var itemDetails: ItemDetailsModel //acesso a todos os dados da view
    private val favorites = Favorites(context)
    private val service = CallsApiService()
    val details = MutableLiveData<String> ()

    fun getMDetail(){
        viewModelScope.launch {
            details.value = service.getDetail(itemDetails.id!!)
        }
    }

    fun editFavorite() {
        itemDetails.is_favorite = favorites.favoriteManager(itemDetails.id!!)
    }
}