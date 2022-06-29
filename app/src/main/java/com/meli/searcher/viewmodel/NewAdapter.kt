package com.meli.searcher.viewmodel

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.R
import com.meli.searcher.databinding.RecyclerItemListBinding
import com.meli.searcher.model.ItemList

class NewAdapter(

) : RecyclerView.Adapter<NewAdapter.ViewHolder>() {
    private val item: MutableList<ItemList> = mutableListOf()

    class ViewHolder(val view:RecyclerItemListBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind (item : ItemList) {
            view.nameRecyclerItem.text = item.title
            view.priceRecyclerItem.text = item.price.toString()
            view.description1RecyclerItem.text = item.desc1
            view.description2RecyclerItem.text = item.desc2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int {
       return item.size
    }

    fun setItems(list: List<ItemList>) {
        item.clear()
        item.addAll(list)
        notifyDataSetChanged()
    }

}