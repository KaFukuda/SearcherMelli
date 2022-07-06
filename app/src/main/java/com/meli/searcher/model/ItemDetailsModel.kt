package com.meli.searcher.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
class ItemDetailsModel(
    val id: String?,
    val type: String?,
    val title: String?,
    val price: String?,
    val secure_thumbnail: String?,
    val available_quantity: String?,
    var plain_text: String?,
    val pictures: @RawValue List<PicturesModel>,
    var is_favorite: Boolean?
) : Parcelable