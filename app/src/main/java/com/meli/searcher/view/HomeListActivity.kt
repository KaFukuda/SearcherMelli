package com.meli.searcher.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.R
import com.meli.searcher.databinding.ActivityHomeListBinding
import com.meli.searcher.model.DataList.getProducts
import com.meli.searcher.model.ItemList
import com.meli.searcher.viewmodel.NewAdapter

class HomeListActivity : AppCompatActivity() {

    private val bind by lazy { ActivityHomeListBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        supportActionBar?.hide() //remove a barra de ajuda

        val bundle: Bundle? = intent.extras

        val rv: RecyclerView = findViewById(R.id.recycler)
        val adapter = NewAdapter()
        rv.adapter = adapter
        //observable para mudanças
        adapter.setItems(getProducts())
        //val items: List<ItemList> = rv.setAdapter(NewAdapter(items))
    }
}

