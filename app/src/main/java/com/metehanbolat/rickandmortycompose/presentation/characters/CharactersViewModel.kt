package com.metehanbolat.rickandmortycompose.presentation.characters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metehanbolat.rickandmortycompose.domain.use_case.get_characters.GetCharactersUseCase
import com.metehanbolat.rickandmortycompose.model.Characters
import com.metehanbolat.rickandmortycompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    private val _state = mutableStateOf(CharactersState())
    val state: State<CharactersState> = _state

    init {
        getCharacters()
    }

    private fun getCharacters() {
        getCharactersUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CharactersState(character = result.data)
                }
                is Resource.Error -> {
                    _state.value = CharactersState(error = result.message ?: "An unexpected error occurred!")
                }
                is Resource.Loading -> {
                    _state.value = CharactersState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}