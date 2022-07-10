package com.meli.searcher.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PicturesModel(
    val secure_url: String
): Parcelable
