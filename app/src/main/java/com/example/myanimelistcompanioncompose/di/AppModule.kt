package com.example.myanimelistcompanioncompose.di

import com.example.myanimelistcompanioncompose.data.remote.api.JikanApi
import com.example.myanimelistcompanioncompose.data.remote.api.JikanApi.Companion.BASE_URL
import com.example.myanimelistcompanioncompose.data.remote.repository.JikanRepositoryImpl
import com.example.myanimelistcompanioncompose.domain.repository.JikanRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideJikanApi(): JikanApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JikanApi::class.java)
    }

    @Provides
    @Singleton
    fun provideJikanRepository(api: JikanApi): JikanRepository{
        return JikanRepositoryImpl(api)
    }
}