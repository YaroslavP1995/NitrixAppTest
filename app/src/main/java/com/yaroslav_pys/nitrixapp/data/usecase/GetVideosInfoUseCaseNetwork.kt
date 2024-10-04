package com.yaroslav_pys.nitrixapp.data.usecase

import com.yaroslav_pys.nitrixapp.data.remote.dto.VideoData
import com.yaroslav_pys.nitrixapp.domain.repository.VideoInfoRepository
import com.yaroslav_pys.nitrixapp.domain.usecases.GetVideosInfoUseCase
import javax.inject.Inject

class GetVideosInfoUseCaseNetwork @Inject constructor(
    private val repository: VideoInfoRepository
) : GetVideosInfoUseCase {

    override suspend fun getAllVideo(): VideoData? {
        return repository.getAllVideo()
    }
}