package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.AppViewModel
import com.example.myapplication.ui.components.ListTile

@Composable
fun TransactionHistoryScreen(viewModel: AppViewModel) {
    val transactions by viewModel.transactions.collectAsState()
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Transaction History", modifier = Modifier.padding(16.dp))


        LazyColumn(){
            items(transactions!!.results){
                transaction ->  ListTile(icon = Icons.Outlined.Info, label = transaction.category) {

            }
            }
        }
    }
}
