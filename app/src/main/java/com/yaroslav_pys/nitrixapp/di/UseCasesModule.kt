package com.yaroslav_pys.nitrixapp.di

import com.yaroslav_pys.nitrixapp.data.repository.VideoInfoRepositoryImpl
import com.yaroslav_pys.nitrixapp.data.usecase.GetVideosInfoUseCaseNetwork
import com.yaroslav_pys.nitrixapp.domain.repository.VideoInfoRepository
import com.yaroslav_pys.nitrixapp.domain.usecases.GetVideosInfoUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface UseCasesModule {
    @Binds
    @Singleton
    fun bindRegisterUserUseCase(useCase: GetVideosInfoUseCaseNetwork): GetVideosInfoUseCase

    @Binds
    @Singleton
    abstract fun bindVideoInfoRepository(
        videoInfoRepositoryImpl: VideoInfoRepositoryImpl
    ): VideoInfoRepository
}