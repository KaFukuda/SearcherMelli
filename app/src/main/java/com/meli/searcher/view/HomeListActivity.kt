package com.meli.searcher.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.R
import com.meli.searcher.model.DataList.getProducts
import com.meli.searcher.viewmodel.HomeListAdapter

class HomeListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_list)
        supportActionBar?.hide() //remove a barra de ajuda

        /*val recyclerView: RecyclerView = findViewById(R.id.cardView)
        recyclerView.adapter = HomeListAdapter(
            context = this, products = getProducts()
        )*/
    }
}