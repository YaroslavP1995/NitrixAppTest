package com.yaroslav_pys.nitrixapp.data.remote.api

import com.yaroslav_pys.nitrixapp.data.remote.dto.VideoData
import retrofit2.Response
import retrofit2.http.GET

interface GetVideosApi {

    @GET("YaroslavP1995/a6a5bc6346ad00eea9a906e1d7a6392d/raw/gistfile1.txt")
    suspend fun getAllVideo(): Response<VideoData>
}