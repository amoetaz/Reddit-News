package com.redditnews.data.models


import com.google.gson.annotations.SerializedName

data class ArticlesResponse(
    @SerializedName("data")
    val `data`: ArticlesInfoDto?,
    @SerializedName("kind")
    val kind: String?
)