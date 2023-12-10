package com.example.myapplication.ui.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.myapplication.ui.AppViewModel
import com.example.myapplication.ui.components.BottonNavigationMenu
import com.example.myapplication.ui.components.Screen

@Composable
fun HomeScreen(navController: NavController, viewModel: AppViewModel) {
    val selectedScreen = remember { mutableStateOf(0) } // Index of the currently selected screen
    Screen(bottomBar = {
        BottonNavigationMenu(selectedScreen = selectedScreen.value){
            selectedScreen.value = it
        }
    }, components = {

        when(selectedScreen.value){
            0 -> DashboardScreen(viewModel)
            1 -> TransactionHistoryScreen(viewModel)
            2 -> HelpScreen()
        }


    })
}






