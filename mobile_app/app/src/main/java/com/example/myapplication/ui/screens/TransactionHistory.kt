package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.components.ListTile

@Composable
fun TransactionHistory() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "This is the Search screen.", modifier = Modifier.padding(16.dp))
        ListTile(icon = Icons.Filled.AccountBox, label = "adsad") {

        }
    }
}
