package com.redditnews.data.models

import com.google.gson.annotations.SerializedName

open class BaseResponse{
    @SerializedName("kind")
    val kind: String? = null
}