package com.yaroslav_pys.nitrixapp.domain.repository

import com.yaroslav_pys.nitrixapp.data.remote.dto.VideoData

interface VideoInfoRepository {
    suspend fun getAllVideo(): VideoData?
}