package com.yaroslav_pys.nitrixapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("name") var name: String,
    @SerializedName("videos") var nameVideos: List<Video>,
)
