package com.meli.searcher.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.databinding.RecyclerItemListBinding
import com.meli.searcher.model.ItemDetails

class HomeListAdapter : RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {
    private val item: MutableList<ItemDetails> = mutableListOf()

    class ViewHolder(private val view : RecyclerItemListBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind (item: ItemDetails) {
            view.nameRecyclerItem.text = item.title
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

    fun setItems(listFinal: List<ItemDetails>) {
        item.clear()
        item.addAll(listFinal)
        notifyDataSetChanged()
    }

}