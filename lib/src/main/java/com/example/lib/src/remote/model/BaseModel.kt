package com.example.lib.src.remote.model

import com.google.gson.annotations.SerializedName

data class BaseModel<T>(
    @SerializedName("count")
    val itemCount: Int ?= null,
    @SerializedName("next")
    val nextPage: String ?= null,
    @SerializedName("previous")
    val prevPage: String ?= null,
    @SerializedName("results")
    val dataList: List<T> ?= null,
)
