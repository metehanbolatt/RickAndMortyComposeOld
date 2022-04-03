package com.metehanbolat.rickandmortycompose.navigation

sealed class Screen(val route: String) {
    object Characters: Screen(route = "characters_screen")
    object CharacterDetails: Screen(route = "character_details_screen")
}
