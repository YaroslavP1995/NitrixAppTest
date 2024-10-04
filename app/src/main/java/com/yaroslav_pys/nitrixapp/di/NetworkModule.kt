package com.yaroslav_pys.nitrixapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.yaroslav_pys.nitrixapp.BuildConfig.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    private const val TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'"

    @Provides
    @Singleton
    fun provideRetrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit {
        return builder
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(converterFactory: Converter.Factory): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(converterFactory)
    }

    @Provides
    @Singleton
    fun provideConverterFactory(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .setDateFormat(TIME_PATTERN)
            .create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpModuleProvider.provideOkHttpClient()
    }
}