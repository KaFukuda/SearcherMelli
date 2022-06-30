package com.meli.searcher.model

import com.google.gson.annotations.SerializedName

data class DiscoveryCategory(
    @SerializedName("category_name")
    var category_name: String = ""
)
