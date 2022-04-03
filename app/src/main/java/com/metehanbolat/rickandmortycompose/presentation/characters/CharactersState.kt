package com.metehanbolat.rickandmortycompose.presentation.characters

import com.metehanbolat.rickandmortycompose.model.Characters

data class CharactersState(
    val isLoading: Boolean = false,
    val character: Characters? = null,
    val error: String = ""
)