package com.example.myapplication.ui.screens

import LoadingIndicator
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.myapplication.ui.AppViewModel
import com.example.myapplication.ui.components.BottonNavigationMenu
import com.example.myapplication.ui.components.Screen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(navController: NavController, viewModel: AppViewModel) {
    val selectedScreen = remember { mutableStateOf(0) } // Index of the currently selected screen
    val isConnected by viewModel.isConnected.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    Screen(

        bottomBar = {
        BottonNavigationMenu(selectedScreen = selectedScreen.value) {
            selectedScreen.value = it
        }
    }, components = {
        if (isConnected) {
            if (viewModel.isLoading.value) {
                LoadingIndicator()
            } else {
                when (selectedScreen.value) {

                    0 -> DashboardScreen(viewModel)
                    1 -> TransactionHistoryScreen(viewModel)
                    2 -> HelpScreen()
                }
            }

        } else {
            NoInternetScreen()
        }
    })

}






