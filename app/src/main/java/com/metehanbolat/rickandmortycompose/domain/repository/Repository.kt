package com.metehanbolat.rickandmortycompose.domain.repository

import com.metehanbolat.rickandmortycompose.model.Characters
import com.metehanbolat.rickandmortycompose.utils.Resource

interface Repository {
    suspend fun getPage(): Characters
}