package com.meli.searcher.ui.products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.meli.searcher.databinding.ActivityProductDetailsBinding
import com.meli.searcher.model.ItemDetails
import com.squareup.picasso.Picasso

class ProductDetailsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityProductDetailsBinding.inflate(layoutInflater) }
    private lateinit var itemDetails : ItemDetails

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide() //remove toolbar
        itemDetails = intent?.extras?.get("itemDetails") as ItemDetails
        getItemData()
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    private fun getItemData(){
        try{
            binding.detailsTitle.text = itemDetails.title
            binding.detailsMoreInfo.text = itemDetails.available_quantity
            binding.detailsPrice.text = itemDetails.price
            binding.detailsItem.text = itemDetails.plain_text
            Picasso.get().load(itemDetails.pictures[0].secure_url).into(binding.detailsImage)
        }catch (e: Exception){
            Log.e("getItemData", "Unprocessed object of HomeListActivity for ProductDetailsActivity, ERROR : $e")
        }
    }
}

