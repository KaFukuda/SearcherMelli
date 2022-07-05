package com.meli.searcher.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.databinding.ActivityHomeListBinding
import com.meli.searcher.model.ItemDetails
import com.meli.searcher.ui.products.ProductDetailsActivity

class HomeListActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomeListBinding.inflate(layoutInflater) }
    private val homeListViewModel by lazy { HomeListViewModel(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide() //remove toolbar

        val rv: RecyclerView = binding.recycler

        val adapter = HomeListAdapter(
            { openItem(it) },
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
                    binding.msgEmpty.isGone = true
                    when {
                        query.length < 3 -> toastMessage("Não foi possível retornar a busca. Digite uma palavra com mínimo de 3 letras")
                        else -> homeListViewModel.searchByWord(query)
                    }
                    return false
                }

                override fun onQueryTextChange(query: String): Boolean {
                    return false
                }
            })
        }
        setupSearchView()
    }

    override fun onResume() {
        super.onResume()
        if (homeListViewModel._mList.value != null)
            homeListViewModel.verifyFavs()

    }

    private fun openItem(itemDetails: ItemDetails) {
        val intent = Intent(this, ProductDetailsActivity::class.java)
        intent.putExtra("itemDetails", itemDetails)
        startActivity(intent)
    }

    private fun favoritesManager(id: String) {
        homeListViewModel.editFav(id)
    }

    fun toastMessage(message: String) {
        val toast =
            Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL, 0, 0)
        toast.show()
    }
}

/*fun hideKeyboard(view: View) {
    val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}*/


