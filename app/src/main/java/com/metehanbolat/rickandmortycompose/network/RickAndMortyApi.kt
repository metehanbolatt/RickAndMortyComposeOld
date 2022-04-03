package com.metehanbolat.rickandmortycompose.network

import com.metehanbolat.rickandmortycompose.model.Characters
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: String): Characters
}