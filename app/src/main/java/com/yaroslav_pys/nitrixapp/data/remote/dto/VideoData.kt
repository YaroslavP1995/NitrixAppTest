package com.yaroslav_pys.nitrixapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class VideoData(
    @SerializedName("categories") var categories: List<Category>,
)
