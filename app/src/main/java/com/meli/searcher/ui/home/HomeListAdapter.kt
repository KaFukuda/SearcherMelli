package com.meli.searcher.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.R
import com.meli.searcher.databinding.RecyclerItemListBinding
import com.meli.searcher.model.ItemDetailsModel
import com.squareup.picasso.Picasso

class HomeListAdapter(
    val itemListener: (itemDetails: ItemDetailsModel) -> Unit,
    val favListener: (id: String) -> Unit
) : RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {
    private val item: MutableList<ItemDetailsModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            RecyclerItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int {
        if (item.size != 0)
        else
            println("getItemCount: Error in length list -> empty list or invalid characters size")
        return item.size
    }

    fun setItems(listFinal: List<ItemDetailsModel>) {
        item.clear()
        item.addAll(listFinal)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val view: RecyclerItemListBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bind(item: ItemDetailsModel) {

            view.nameRecyclerItem.text = item.title

            Picasso.get().load(item.secure_thumbnail).into(view.imageRecyclerItem)

            val priceBr = String.format("%.2f", item.price?.toDouble())
            "R$ $priceBr".also { view.priceRecyclerItem.text = it }

            "Disponível: ${item.available_quantity} unid.".also {
                view.description1RecyclerItem.text = it
            }

            val payment: String = String.format("%.2f", item.price?.toDouble()?.div(12))
            "em 12x R$ $payment sem juros".also { view.description2RecyclerItem.text = it }

            Picasso.get().load(
                if (item.is_favorite!!) R.drawable.heart_full else R.drawable.heart_empty
            ).into(view.favIcon)

            view.cardView.setOnClickListener {
                itemListener(item)
                Log.d("SEND_DATA", "Send: $payment")
            }

            view.favIcon.setOnClickListener {
                favListener(item.id!!)
            }
        }
    }
}