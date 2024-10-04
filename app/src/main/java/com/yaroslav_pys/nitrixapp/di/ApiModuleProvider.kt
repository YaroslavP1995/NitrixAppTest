package com.yaroslav_pys.nitrixapp.di

import retrofit2.Retrofit

interface ApiModuleProvider <T> {
    fun provideApi(retrofit: Retrofit): T
}