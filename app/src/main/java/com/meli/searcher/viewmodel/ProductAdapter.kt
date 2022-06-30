package com.meli.searcher.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.databinding.RecyclerItemListBinding
import com.meli.searcher.model.DiscoveryCategory
import com.meli.searcher.model.ItemList

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private val item: MutableList<DiscoveryCategory> = mutableListOf()

    class ViewHolder(private val view : RecyclerItemListBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind (item : DiscoveryCategory) {
            view.nameRecyclerItem.text = item.category_name
            /*view.priceRecyclerItem.text = item.price.toString()
            view.description1RecyclerItem.text = item.desc1
            view.description2RecyclerItem.text = item.desc2*/
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

    fun setItems(item: MutableList<DiscoveryCategory>) {
        item.clear()
        item.addAll(item)
        notifyDataSetChanged()
    }

}