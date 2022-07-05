package com.meli.searcher.ui.products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.meli.searcher.R
import com.meli.searcher.databinding.ActivityProductDetailsBinding
import com.meli.searcher.model.ItemDetails
import com.squareup.picasso.Picasso

class ProductDetailsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityProductDetailsBinding.inflate(layoutInflater) }
    private val productDetailsViewModel by lazy { ProductDetailsViewModel(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide() //remove toolbar
        val itemDetails = intent?.extras?.get("itemDetails") as ItemDetails
        productDetailsViewModel.itemDetails = itemDetails // atribuindo viewModel a ItemDetails
        getItemData()
        setListener()
        productDetailsViewModel.details.observe(this,{
            binding.detailsItem.text = it
        })
        productDetailsViewModel.getMDetail()
    }

    private fun getItemData() {
        try {
            binding.detailsTitle.text = productDetailsViewModel.itemDetails.title
            binding.detailsMoreInfo.text = productDetailsViewModel.itemDetails.available_quantity
            binding.detailsPrice.text = String.format("%.2f",productDetailsViewModel.itemDetails.price?.toDouble())
            Picasso.get().load(productDetailsViewModel.itemDetails.pictures[0].secure_url).into(binding.detailsImage)
            toggleIcon()
        } catch (e: Exception) {
            Log.e(
                "getItemData",
                "Unprocessed object of HomeListActivity for ProductDetailsActivity, ERROR : $e"
            )
        }
    }

    private fun setListener() {
        binding.favIconDetail.setOnClickListener {
            productDetailsViewModel.editFavorite()
            toggleIcon()
        }
    }

    private fun toggleIcon() {
        binding.favIconDetail.setImageResource(
            if (productDetailsViewModel.itemDetails.is_favorite!!) R.drawable.heart_blue else R.drawable.heart
        )
    }

}

