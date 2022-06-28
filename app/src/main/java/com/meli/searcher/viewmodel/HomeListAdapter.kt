package com.meli.searcher.viewmodel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.meli.searcher.R
import com.meli.searcher.model.ItemList

class HomeListAdapter(
    private val context : Context,
    products : List<ItemList>
): RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    private val products = products.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun vinculateValues( productItem: ItemList){
            val name = itemView.findViewById<TextView>(R.id.name_recycler_item)
            name.text = productItem.title

            val price = itemView.findViewById<TextView>(R.id.price_recycler_item)
            price.text = productItem.price.toString()

            val descript1 = itemView.findViewById<TextView>(R.id.description1_recycler_item)
            descript1.text = productItem.desc1

            val descript2 = itemView.findViewById<TextView>(R.id.description2_recycler_item)
            descript2.text = productItem.desc2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //cria a ref , responsavel por fazer o bind das views
        val inflater = LayoutInflater.from(context) // criado o context no construtor pq nao acha no this
        val view = inflater.inflate(R.layout.recycler_item_list, parent, false) //cria a view exclusiva
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //indica para o adapter o q esta colocando: item e a posicao
        val productItem = products[position]
        holder.vinculateValues(productItem)
    }

    //tamanho da lista
    override fun getItemCount(): Int = products.size
    /*fun updateInfos(products: List<ItemList>) {
        this.products.clear() //para nao ter dados duplicados
        this.products.addAll(products) //adiciona as mudanças da mutableList
        notifyDataSetChanged() //atualiza a mutableList
    }*/
}