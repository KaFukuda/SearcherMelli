package com.meli.searcher.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
class ItemDetailsModel(
    val id: String?,
    val type: String?,
    val title: String?,
    val price: String?,
    val secure_thumbnail: String?,
    val available_quantity: String?,
    val pictures: @RawValue List<PicturesModel>,
    var is_favorite: Boolean?
) : Parcelable