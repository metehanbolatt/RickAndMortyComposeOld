package com.metehanbolat.rickandmortycompose.data

import com.metehanbolat.rickandmortycompose.domain.repository.Repository
import com.metehanbolat.rickandmortycompose.model.Characters
import com.metehanbolat.rickandmortycompose.network.RickAndMortyApi
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
): Repository {
    override suspend fun getPage(): Characters {
        return api.getAllCharacters("1")
    }
}