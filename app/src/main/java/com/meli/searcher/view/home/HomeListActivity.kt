package com.meli.searcher.view.home

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.app.NotificationCompat.getExtras
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.R
import com.meli.searcher.databinding.ActivityHomeListBinding
import com.meli.searcher.model.DiscoveryCategory
import com.meli.searcher.model.ItemDetails
import com.meli.searcher.view.Products.DetailsActivity


class HomeListActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomeListBinding.inflate(layoutInflater) }
    private val homeListViewModel by lazy { HomeListViewModel() }
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide() //remove a barra de ajuda

        val rv: RecyclerView = binding.recycler
        val adapter = HomeListAdapter { openItem(it) }
        rv.adapter = adapter


         homeListViewModel._mList.observe(this) {
            adapter.setItems(it)
        }

        //método que filtra os dados da homeListModelView
        val wordSearchView = binding.inputField
        fun setupSearchView() {
            wordSearchView.clearFocus() //limpa o campo
            wordSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    binding.msgEmpty.isGone = true
                    homeListViewModel.searchByWord(query)
                    return false
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    homeListViewModel.searchByWord("")
                    binding.msgEmpty.isVisible = true
                    return true
                }
            })
        }
        setupSearchView()

    }

    override fun onStart() {
        super.onStart()
        //val intent = Intent(this, DiscoveryCategory::class.java)

    }

    //M. ao clicar no item aponta pro valor setado
    private fun openItem(itemDetails: ItemDetails) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("title", itemDetails.title)
        intent.putExtra("price", itemDetails.price)
        intent.putExtra( "available_quantity", itemDetails.available_quantity)
        intent.putExtra("secure_thumbnail",itemDetails.secure_thumbnail)
        startActivity(intent)
    }

    private fun toastMsg(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }



}


