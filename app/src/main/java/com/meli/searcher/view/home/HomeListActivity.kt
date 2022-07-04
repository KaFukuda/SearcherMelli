package com.meli.searcher.view.home

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.databinding.ActivityHomeListBinding
import com.meli.searcher.model.ItemDetails
import com.meli.searcher.view.products.DetailsActivity
import kotlin.math.roundToInt

class HomeListActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomeListBinding.inflate(layoutInflater) }
    private val homeListViewModel by lazy { HomeListViewModel(applicationContext) }
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide() //remove a barra de ajuda

        val rv: RecyclerView = binding.recycler

        val adapter = HomeListAdapter (
            { openItem(it) },
            { manageFavs(it) }
        )

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

                override fun onQueryTextChange(query: String): Boolean {
                    return false
                }
            })
        }
        setupSearchView()
    }


    //M. ao clicar no item aponta pro valor setado
    private fun openItem(itemDetails: ItemDetails) {

        val intent = Intent(this, DetailsActivity::class.java)
        //val bundle = bundleOf("itemDetails" to itemDetails)
        //intent.putExtras(bundle)
        intent.putExtra("itemDetails" , itemDetails )
        startActivity(intent)
    }
    private fun toastMsg(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    private fun manageFavs(id: String){
        homeListViewModel.editFav(id)
    }

}

/*fun hideKeyboard(view: View) {
    val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}*/


