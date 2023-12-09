package com.example.myapplication.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.ui.AppViewModel
import com.example.myapplication.ui.components.BottonNavigationMenu
import com.example.myapplication.ui.components.Screen

@Composable
fun HomeScreen(navController: NavController, viewModel: AppViewModel) {


Greeting()
}


@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "This is the Settings screen.", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun Greeting() {
    val selectedScreen = remember { mutableStateOf(0) } // Index of the currently selected screen
    Screen(bottomBar = {
        BottonNavigationMenu(selectedScreen = selectedScreen.value){
            Log.d("TAG", "$it: ")
            selectedScreen.value = it
        }
    }, components = {

        when(selectedScreen.value){
            0 -> DashBoard()
            1 -> TransactionHistory()
            2 -> SettingsScreen()
        }


    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Greeting()
}