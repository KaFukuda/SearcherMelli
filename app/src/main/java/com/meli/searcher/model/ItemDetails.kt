package com.meli.searcher.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
class ItemDetails (

    val id : String?, //"MLB1152846407"
    val type : String?, //"MLB1152846407"
    var site_id : String?, //MLB
    val title: String?, //"Ração P/carpas Sticks Premium Mix 6x1 -6kg"
    val category_id: String?, //"MLB1094"
    val price: String?, //399.9
    val secure_thumbnail : String?, //"httpS://http2.mlstatic.com/D_897035-MLB50174953428_062022-I.jpg"
    val url : String?, //"http://http2.mlstatic.com/D_897035-MLB50174953428_062022-O.jpg" image 426x500"
    val currency_id : String?,
    val available_quantity: String?,
    var plain_text: String?,
    val pictures: @RawValue List<Pictures>,
    var is_favorite: Boolean?

    ): Parcelable
