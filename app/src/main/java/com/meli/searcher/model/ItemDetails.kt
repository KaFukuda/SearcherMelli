package com.meli.searcher.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
class ItemDetails(
    val id: String?,
    val type: String?,
    val title: String?,
    val price: String?,
    val secure_thumbnail: String?,
    val available_quantity: String?,
    var plain_text: String?,
    val pictures: @RawValue List<Pictures>,
    var is_favorite: Boolean?
) : Parcelable

/*val url : String?, //"http://http2.mlstatic.com/D_897035-MLB50174953428_062022-O.jpg" image 426x500"
val currency_id : String?,
val category_id: String?, //"MLB1094"
var site_id : String?, //MLB*/