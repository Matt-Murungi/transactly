package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.AppViewModel
import com.example.myapplication.ui.screens.HomeScreen

@Composable
fun AppNavigation() {

    val appViewModel = hiltViewModel<AppViewModel>()

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.Home.name
    ) {

        composable(AppScreens.Home.name) {
            HomeScreen(navController = navController, appViewModel)
        }

    }

}