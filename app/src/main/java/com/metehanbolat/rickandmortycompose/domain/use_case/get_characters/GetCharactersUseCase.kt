package com.metehanbolat.rickandmortycompose.domain.use_case.get_characters

import com.metehanbolat.rickandmortycompose.domain.repository.Repository
import com.metehanbolat.rickandmortycompose.model.Characters
import com.metehanbolat.rickandmortycompose.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Resource<Characters>> = flow {
        try {
            emit(Resource.Loading())
            val characters = repository.getPage()
            emit(Resource.Success(characters))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection!"))
        }
    }
}