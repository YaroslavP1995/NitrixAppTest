package com.yaroslav_pys.nitrixapp.di

import com.yaroslav_pys.nitrixapp.data.remote.api.GetVideosApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class GetVideoInfoApiModule : ApiModuleProvider<GetVideosApi> {
    @Singleton
    @Provides
    override fun provideApi(retrofit: Retrofit): GetVideosApi {
        return retrofit.create(GetVideosApi::class.java)
    }

}