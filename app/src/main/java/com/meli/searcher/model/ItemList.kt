package com.meli.searcher.model

import android.service.controls.templates.ThumbnailTemplate
import java.math.BigDecimal

//test
data class ItemList(
    val title: String,
    val price: Int,
    val desc1: String,
    val desc2: String
)

data class Product(
    val id : Int,
    val site_id : String?,
    val title: String,
    val price: BigDecimal,
    val thumbnail : ThumbnailTemplate

)

//other Details > results > id , site_id , title , price , thumbnail