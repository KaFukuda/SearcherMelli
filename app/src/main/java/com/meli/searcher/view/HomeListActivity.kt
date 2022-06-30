package com.meli.searcher.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.R
import com.meli.searcher.databinding.ActivityHomeListBinding
import com.meli.searcher.model.DataList.getProducts
import com.meli.searcher.model.DiscoveryCategory
import com.meli.searcher.util.NetworkUtils
import com.meli.searcher.viewmodel.ProductAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeListActivity : AppCompatActivity() {

    private val bind by lazy { ActivityHomeListBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        supportActionBar?.hide() //remove a barra de ajuda

        val rv: RecyclerView = findViewById(R.id.recycler)
        val adapter = ProductAdapter()
        rv.adapter = adapter
        //adapter.setItems() //observable para mudanças


        val service = NetworkUtils.createService()
        val call: Call<MutableList<DiscoveryCategory>> = service.getByEntryData()
        call.enqueue(object : Callback<MutableList<DiscoveryCategory>> {
            override fun onResponse(
                call: Call<MutableList<DiscoveryCategory>>,
                res: Response<MutableList<DiscoveryCategory>>
            ) {
                var data = mutableListOf<String>()
                res.body()?.iterator()?.forEach {
                    data.add(it.category_name)
                }
                println("Total de dados ${data.count()}")
            }

            override fun onFailure(call: Call<MutableList<DiscoveryCategory>>, t: Throwable) {
                println("erro na chamada")
            }
        })
    }
}

