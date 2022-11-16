package com.redditnews.data.models


import com.google.gson.annotations.SerializedName

data class ArticleInfoDto(
    @SerializedName("data")
    val `data`: ArticleDto?,
    @SerializedName("kind")
    val kind: String?
)