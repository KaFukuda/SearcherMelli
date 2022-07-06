package com.meli.searcher.model

enum class ListingTypesModel(valueApi:String, type: String = "") {
    BRONZE("bronze"),
    FREE("free"),
    GOLD("gold_pro"),
    GOLD_PREMIUM("gold_special"),
    SILVER("silver")
}