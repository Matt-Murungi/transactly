package com.example.myapplication.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.AppViewModel
import com.example.myapplication.ui.components.CustomIconButton
import com.example.myapplication.ui.components.ListTile
import com.example.myapplication.ui.components.ModalDialog

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun TransactionHistoryScreen(viewModel: AppViewModel) {
    val transactions by viewModel.transactions.collectAsState()
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Transaction History", modifier = Modifier.padding(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomIconButton(icon = Icons.Outlined.ArrowBack, onClick = {
                    viewModel.getPaginatedTransaction(transactions!!.previous)
                })
                CustomIconButton(icon = Icons.Outlined.ArrowForward, onClick = {
                    viewModel.getPaginatedTransaction(transactions!!.next)

                })
            }
        }

        LazyColumn() {
            items(transactions!!.results) { transaction ->
                ListTile(icon = Icons.Outlined.Info, label = transaction.category, subtitle = "${transaction.amount}", trailing = transaction.txfinish) {

                    viewModel.showTransactionHistoryDialog.value = true
                    viewModel.selectedTransaction.value = transaction
                }
            }
        }

        if(viewModel.showTransactionHistoryDialog.value){
            ModalDialog(onDismissRequest = {viewModel.showTransactionHistoryDialog.value = false}) {


                Text(text = "Transaction History", fontWeight = FontWeight.W600, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp), textAlign = TextAlign.Center)

                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Amount : ${viewModel.selectedTransaction.value!!.amount}", modifier = Modifier.padding(vertical = 10.dp))
                Text(text = "Date : ${viewModel.selectedTransaction.value!!.txfinish}", modifier = Modifier.padding(vertical = 10.dp))
                Text(text = "Category : ${viewModel.selectedTransaction.value!!.category}", modifier = Modifier.padding(vertical = 10.dp))
                Text(text = "Type : ${viewModel.selectedTransaction.value!!.type}", modifier = Modifier.padding(vertical = 10.dp))
                Text(text = "Service : ${viewModel.selectedTransaction.value!!.service}", modifier = Modifier.padding(vertical = 10.dp))

                Spacer(modifier = Modifier.height(10.dp))


            }
        }

    }
}
