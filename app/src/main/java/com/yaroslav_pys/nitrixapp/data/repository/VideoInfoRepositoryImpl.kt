package com.yaroslav_pys.nitrixapp.data.repository

import com.yaroslav_pys.nitrixapp.data.remote.api.GetVideosApi
import com.yaroslav_pys.nitrixapp.data.remote.dto.VideoData
import com.yaroslav_pys.nitrixapp.domain.repository.VideoInfoRepository
import javax.inject.Inject

class VideoInfoRepositoryImpl @Inject constructor(
    private val api: GetVideosApi,
) : VideoInfoRepository {

    override suspend fun getAllVideo(): VideoData? {
        return api.getAllVideo().body()
    }
}