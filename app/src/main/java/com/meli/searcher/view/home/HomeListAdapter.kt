package com.meli.searcher.view.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.databinding.RecyclerItemListBinding
import com.meli.searcher.model.ItemDetails
import com.squareup.picasso.Picasso
import okhttp3.MediaType.Companion.toMediaType
import kotlin.math.roundToInt

class HomeListAdapter(
    val itemListener: (itemDetails: ItemDetails) -> Unit
) : RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {
    private val item: MutableList<ItemDetails> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            RecyclerItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun setItems(listFinal: List<ItemDetails>) {
        item.clear()
        item.addAll(listFinal)
        notifyDataSetChanged()
    }


    inner class ViewHolder(private val view: RecyclerItemListBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(item: ItemDetails) {
            view.nameRecyclerItem.text = item.title
            Picasso.get().load(item.secure_thumbnail).into(view.imageRecyclerItem)
            val priceBr = item.price.toString()
            view.priceRecyclerItem.text = "R$ $priceBr"
            view.description1RecyclerItem.text = "Disponível para venda: ${item.available_quantity}"
            val payment: String = (item.price?.toDouble()?.div(12))?.roundToInt().toString()
            view.description2RecyclerItem.text = "em 12x R$ $payment"

            fun isNational() {
                if (item.site_id == "MLB") {
                    "Produto nacional"
                } else {
                    "Produto internacional"
                }
            }
            isNational()

            view.cardView.setOnClickListener {
                Log.d("SENDDATA", "enviei dado: ${item.site_id}")
                itemListener(item)
            }


        }
    }
}

/*
val bundle = Bundle()
bundle.putString("secure_thumbnail", item.secure_thumbnail)
bundle.putString("title", item.title)
bundle.putString("price", item.price.toString())
bundle.putString("available_quantity", item.available_quantity)
bundle.putString("site_id", isNational().toString())*/