package com.meli.searcher.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.R
import com.meli.searcher.databinding.ActivityHomeListBinding

class HomeListActivity : AppCompatActivity() {

    private val bind by lazy { ActivityHomeListBinding.inflate(layoutInflater) }
    private val homeListViewModel by lazy { HomeListViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        supportActionBar?.hide() //remove a barra de ajuda

        val rv: RecyclerView = bind.recycler
        val adapter = HomeListAdapter()
        rv.adapter = adapter

        homeListViewModel._mList.observe(this, {
            adapter.setItems(it) //observable para mudanças
        })

        homeListViewModel.searchByWord("Carros")

    }
}

