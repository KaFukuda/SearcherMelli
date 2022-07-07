package com.meli.searcher.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.R
import com.meli.searcher.databinding.ActivityHomeListBinding
import com.meli.searcher.model.ItemDetailsModel
import com.meli.searcher.ui.products.ProductDetailsActivity
import com.meli.searcher.util.ErrorMessages

class HomeListActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomeListBinding.inflate(layoutInflater) }
    private val homeListViewModel by lazy { HomeListViewModel(applicationContext) }
    var errorMessages = ErrorMessages()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide() //remove toolbar
        val rv: RecyclerView = binding.recycler

        val adapter = HomeListAdapter(
            { openItemInProductDetails(it) },
            { favoritesManager(it) }
        )

        rv.adapter = adapter

        homeListViewModel._mList.observe(this) {
            adapter.setItems(it)
        }

        //This method filter data of homeListModelView
        val wordSearchView = binding.inputField
        fun setupSearchView() {
            wordSearchView.clearFocus() //clean input field
            wordSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {

                    binding.msgEmpty.isGone = true //remove phrase

                    when (query.length) {
                        in 0..3 -> errorMessages.messageErrorOnSnack(binding.root, "Não foi possível retornar a busca. Digite uma palavra maior.")
                        else -> homeListViewModel.searchByWord(query)
                    }
                    return false
                }

                override fun onQueryTextChange(query: String): Boolean {
                    binding.msgEmpty.isGone = false //add phrase
                    return false
                }
            })
        }
        setupSearchView()
    }

    override fun onResume() {
        super.onResume()

        //verify if list is null and apply method of favorites
        if (homeListViewModel._mList.value != null)
            homeListViewModel.verifyByIdFavoriteList()

        //remove focusable of searchView
        val searchView: SearchView = findViewById(R.id.input_field)
        searchView.setQuery("", false)
        searchView.queryHint = "Buscar no Mercado Livre";
        binding.root.requestFocus()

    }

    private fun openItemInProductDetails(itemDetails: ItemDetailsModel) {
        val intent = Intent(this, ProductDetailsActivity::class.java)
        intent.putExtra("itemDetails", itemDetails)
        startActivity(intent)
    }

    private fun favoritesManager(id: String) {
        homeListViewModel.editFavorites(id)
    }

}




