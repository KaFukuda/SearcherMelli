package com.meli.searcher.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PicturesModel(
    val secure_url: String
): Parcelable
