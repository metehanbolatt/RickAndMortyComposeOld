package com.metehanbolat.rickandmortycompose.di

import com.metehanbolat.rickandmortycompose.data.RepositoryImpl
import com.metehanbolat.rickandmortycompose.domain.repository.Repository
import com.metehanbolat.rickandmortycompose.network.RickAndMortyApi
import com.metehanbolat.rickandmortycompose.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRickAndMortyApi(): RickAndMortyApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: RickAndMortyApi): Repository {
        return RepositoryImpl(api)
    }

}