package com.meli.searcher.view.Products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meli.searcher.R
import com.meli.searcher.databinding.ActivityDetailsBinding
import com.meli.searcher.databinding.ActivityHomeListBinding

class DetailsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide() //remove a barra de ajuda


        getItemData()
    }

    private fun getItemData(){
        val dataTitle = intent?.extras?.getString("title")
        binding.detailsTitle.text = dataTitle

        //val dataPhoto = intent?.extras?.getString("secure_thumbnail")
        //binding.detailsImage.drawable. = dataPhoto.toString()

        val dataQuantity = intent?.extras?.getString("available_quantity")
        binding.detailsMoreInfo.text = dataQuantity

        val dataPrice = intent?.extras?.getString("price")
        binding.detailsPrice.text = dataPrice

    }
}