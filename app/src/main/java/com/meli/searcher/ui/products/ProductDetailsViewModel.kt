package com.meli.searcher.ui.products

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.R
import com.meli.searcher.databinding.RecyclerItemListBinding
import com.meli.searcher.model.ItemDetails
import com.meli.searcher.service.api.ItemsHomeService
import com.meli.searcher.util.Favorites
import kotlinx.android.synthetic.main.activity_product_details.*
import kotlinx.coroutines.launch

class ProductDetailsViewModel(
    context: Context
): ViewModel() {
    lateinit var itemDetails: ItemDetails //acesso a todos os dados da view
    private val favorites = Favorites(context)
    private val service = ItemsHomeService()
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