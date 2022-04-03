package com.metehanbolat.rickandmortycompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.metehanbolat.rickandmortycompose.presentation.characters.CharactersScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Characters.route
    ) {
        composable(route = Screen.Characters.route) {
            CharactersScreen(navController = navController)
        }
        composable(route = Screen.CharacterDetails.route) {

        }
    }
}