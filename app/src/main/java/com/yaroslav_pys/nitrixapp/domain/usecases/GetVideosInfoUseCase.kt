package com.yaroslav_pys.nitrixapp.domain.usecases

import com.yaroslav_pys.nitrixapp.data.remote.dto.VideoData

interface GetVideosInfoUseCase {
    suspend fun getAllVideo(): VideoData?
}