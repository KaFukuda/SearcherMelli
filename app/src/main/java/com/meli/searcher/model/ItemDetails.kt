package com.meli.searcher.model

import android.service.controls.templates.ThumbnailTemplate
import java.math.BigDecimal
import java.util.concurrent.locks.Condition

data class ItemDetails(
    val id : String, //"MLB1152846407"
    val type : String, //"MLB1152846407"
    val site_id : String, //MLB
    val title: String, //"Ração P/carpas Sticks Premium Mix 6x1 -6kg"
    val category_id: String, //"MLB1094"
    val price: BigDecimal, //399.9
    val secure_thumbnail : String, //"httpS://http2.mlstatic.com/D_897035-MLB50174953428_062022-I.jpg"
    val url : String, //"http://http2.mlstatic.com/D_897035-MLB50174953428_062022-O.jpg" image 426x500"
    val currency_id : String,
    val value_name: String,
    val available_quantity: String

)

