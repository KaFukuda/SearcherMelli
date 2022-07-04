package com.meli.searcher.view.products

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meli.searcher.databinding.ActivityDetailsBinding
import com.meli.searcher.model.ItemDetails
import com.squareup.picasso.Picasso
import android.widget.ImageView as Any

class DetailsActivity() : AppCompatActivity() {

    private val binding by lazy { ActivityDetailsBinding.inflate(layoutInflater) }
    private lateinit var itemDetails : ItemDetails
    //private val sharedPreferences =  getPreferences(Context.MODE_PRIVATE)
    //private val favorites = sharedPreferences.getStringSet("FAVS", mutableSetOf())?.toMutableSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide() //remove a barra de ajuda

        itemDetails = intent?.extras?.get("itemDetails") as ItemDetails

        getItemData()

        //favorites?.add(itemDetails.id)
        // adaptar sharedPreferences.edit().putStringSet("FAVORITES", listFavorites).apply()
    }

    private fun getItemData(){

        binding.detailsTitle.text = itemDetails.title
        binding.detailsMoreInfo.text = itemDetails.available_quantity
        binding.detailsPrice.text = itemDetails.price

        if(itemDetails.pictures != null)
            Picasso.get().load(itemDetails.pictures[0].secure_url).into(binding.detailsImage)

    }

}

