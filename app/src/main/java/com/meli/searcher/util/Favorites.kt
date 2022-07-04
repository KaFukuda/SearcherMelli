package com.meli.searcher.util

import android.content.Context

class Favorites( val context : Context) {

    private val idShared = "IDS_ITEM_FAV"

    //declarando
    private val sharedPreferences = context.getSharedPreferences(idShared , Context.MODE_PRIVATE)


    //acessando a lista
    fun getListFavs(): MutableSet<String>{
        return sharedPreferences.getStringSet(idShared, mutableSetOf())?.toMutableSet()!!
    }

    //adiciona e remove favoritos
    fun manageFavs(id: String) {
        val list = getListFavs()
        val result = list.add(id)

        if(!result)
            list.remove(id)

        sharedPreferences.edit().putStringSet(idShared, list).apply()
    }


}