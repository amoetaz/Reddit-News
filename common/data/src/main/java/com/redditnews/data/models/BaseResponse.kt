package com.redditnews.data.models

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("kind")
    val kind: String?
)