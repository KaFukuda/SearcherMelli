package com.meli.searcher.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meli.searcher.R

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar?.hide() //remove a barra de ajuda
    }
}