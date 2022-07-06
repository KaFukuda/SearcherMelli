package com.meli.searcher.ui.products

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import com.meli.searcher.R
import com.meli.searcher.databinding.ActivityProductDetailsBinding
import com.meli.searcher.model.ItemDetailsModel
import com.meli.searcher.ui.home.HomeListActivity
import com.squareup.picasso.Picasso

class ProductDetailsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityProductDetailsBinding.inflate(layoutInflater) }
    private val productDetailsViewModel by lazy { ProductDetailsViewModel(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide() //remove toolbar
        val itemDetails = intent?.extras?.get("itemDetails") as ItemDetailsModel
        productDetailsViewModel.itemDetails = itemDetails // atribuindo viewModel a ItemDetails
        getItemData()
        setListener()
        returnHome()
        productDetailsViewModel.details.observe(this) { binding.detailsItem.text = it }
        productDetailsViewModel.getMDetail()
    }

    private fun getItemData() {
        try {
            binding.detailsTitle.text = productDetailsViewModel.itemDetails.title

            val price = String.format("%.2f", productDetailsViewModel.itemDetails.price?.toDouble())
            " R$ $price ".also { binding.detailsPrice.text = it }

            Picasso.get().load(productDetailsViewModel.itemDetails.pictures[0].secure_url)
                .into(binding.detailsImage)
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

    private fun returnHome(){
        val intent = Intent( this, HomeListActivity::class.java)
        val iconSearch: ImageView = findViewById(R.id.iconSearch)
        iconSearch.setOnClickListener {
            startActivity(intent)
        }
    }

    private fun toggleIcon() {
        binding.favIconDetail.setImageResource(
            if (productDetailsViewModel.itemDetails.is_favorite!!) R.drawable.heart_full else R.drawable.heart_empty
        )
    }

}

