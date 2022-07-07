package com.meli.searcher.util

import android.content.Context

class Favorites(context : Context) {

    private val idShared = "IDS_ITEM_FAV"

    //declare
    private val sharedPreferences = context.getSharedPreferences(idShared , Context.MODE_PRIVATE)

    //access favorite's list
    fun getListOfFavorites(): MutableSet<String>{
        return sharedPreferences.getStringSet(idShared, mutableSetOf())?.toMutableSet()!!
    }

    //add and remove favorite items
    fun favoriteManager(id: String):Boolean {
        val list = getListOfFavorites()
        val result = list.add(id)

        if(!result)
            list.remove(id)

        sharedPreferences.edit().putStringSet(idShared, list).apply()
    return result
    }
}