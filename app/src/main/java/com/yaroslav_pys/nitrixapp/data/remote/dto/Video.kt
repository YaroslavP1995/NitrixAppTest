package com.yaroslav_pys.nitrixapp.data.remote.dto

data class Video(
    val description: String,
    val sources: List<String>,
    val subtitle: String,
    val thumb: String,
    val title: String
)
