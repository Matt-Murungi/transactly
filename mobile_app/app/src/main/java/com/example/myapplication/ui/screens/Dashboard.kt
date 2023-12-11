package com.example.myapplication.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.AppViewModel
import com.example.myapplication.ui.UIConstants
import com.example.myapplication.ui.components.BarGraph
import com.example.myapplication.ui.components.DatePickerCard
import com.example.myapplication.ui.components.DatePickerComposable
import com.example.myapplication.ui.components.ModalDialog
import com.example.myapplication.ui.components.SummaryCard
import com.example.myapplication.ui.theme.Purple40

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DashboardScreen(viewModel: AppViewModel) {
    val transactionsByCategory by viewModel.transactionsByCategory.collectAsState()
    val transactionsByType by viewModel.transactionByType.collectAsState()



            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Analytics", fontWeight = FontWeight.W700, color = Color.Gray)
                    IconButton(onClick = { viewModel.showDialog.value = true }) {
                        Icon(imageVector = Icons.Outlined.DateRange, contentDescription = "filter")
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Divider()

                Spacer(modifier = Modifier.height(20.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    SummaryCard(
                        title = "Total Amount",
                        subtitle = "UGX",
                        icon = Icons.Outlined.Info,
                        detail = viewModel.totalTransactionsAmount.value,

                        )

                    SummaryCard(
                        title = "Transactions",
                        icon = Icons.Outlined.Info,
                        detail = viewModel.numberOfTransactions.value
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {


                    Spacer(modifier = Modifier.height(10.dp))

                    BarGraph(
                        title = "Categories",
                        data = transactionsByCategory,
                        showDateRange = false
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    BarGraph(
                        title = "Transaction Type",
                        data = transactionsByType,
                        showDateRange = false
                    )
                    Spacer(modifier = Modifier.height(10.dp))



                }

                if (viewModel.showDialog.value) {
                    ModalDialog(onDismissRequest = { viewModel.showDialog.value = false }) {
                        Text(
                            text = "Date Filter", fontWeight = FontWeight.W600, modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp), textAlign = TextAlign.Center
                        )

                        DatePickerCard(
                            title = if (viewModel.selectedStartDate.value == null) {
                                "Start Date"
                            } else {
                                viewModel.selectedStartDate.value!!
                            }
                        ) {
                            viewModel.showCalendar.value = true
                            viewModel.calendarType.value = UIConstants.START_DATE_CALENDAR
                        }

                        DatePickerCard(
                            title = if (viewModel.selectedEndDate.value == null) {
                                "End Date"
                            } else {
                                viewModel.selectedEndDate.value!!
                            }
                        ) {
                            viewModel.showCalendar.value = true

                            viewModel.calendarType.value = UIConstants.END_DATE_CALENDAR

                        }
                        if (viewModel.showDialog.value) {
                            DatePickerComposable(
                                showDialog = viewModel.showCalendar.value,
                                title = "from",
                                onDismiss = { viewModel.showCalendar.value = false },
                                onDateChange = {
                                    if (viewModel.calendarType.value == UIConstants.START_DATE_CALENDAR) {
                                        viewModel.setSelectedStartDate(it.toString())
                                        viewModel.showCalendar.value = false

                                    } else {
                                        viewModel.setSelectedEndDate(it.toString())
                                        viewModel.showCalendar.value = false

                                    }
                                })
                        }
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    10.dp
                                ),
                            colors = ButtonDefaults.buttonColors(Purple40),

                            onClick = { viewModel.getFilteredTransactions() }) {
                            Text(text = "FILTER")
                        }
                    }
                }

            }
        }

