package com.meli.searcher.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.databinding.ActivityHomeListBinding
import com.meli.searcher.model.ItemDetails


class HomeListActivity : AppCompatActivity() {

    private val bind by lazy { ActivityHomeListBinding.inflate(layoutInflater) }
    private val homeListViewModel by lazy { HomeListViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        supportActionBar?.hide() //remove a barra de ajuda

        val rv: RecyclerView = bind.recycler
        val adapter = HomeListAdapter { openItem(it) }
        rv.adapter = adapter

        homeListViewModel._mList.observe(this) {
            adapter.setItems(it) //observable para mudanças
        }

        //homeListViewModel.searchByWord("Playstation")
        val wordSearchView = bind.inputField
        fun setupSearchView() {
            wordSearchView.clearFocus() //limpa o campo
            wordSearchView.setOnQueryTextListener (object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    homeListViewModel.searchByWord(query)
                    return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    return true
                }
            })
        }
        setupSearchView()
    }

    private fun openItem(itemDetails: ItemDetails) {
        println(itemDetails.title)
    }

    private fun toast(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}

