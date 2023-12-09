package com.example.myapplication.ui.screens

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
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.components.BarGraph
import com.example.myapplication.ui.components.CustomCard
import com.example.myapplication.ui.components.LegendItem
import com.example.myapplication.ui.components.SummaryCard
import com.example.myapplication.ui.theme.BarGraphColor
import com.example.myapplication.ui.theme.PieColor1
import com.example.myapplication.ui.theme.PieColor2
import com.example.myapplication.ui.theme.PieColor3
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.line.LineChartData
import com.github.tehras.charts.piechart.PieChart
import com.github.tehras.charts.piechart.PieChartData
import com.github.tehras.charts.piechart.renderer.SimpleSliceDrawer

@Composable
fun DashBoard() {
    val showDialog = remember { mutableStateOf(false) }
    val selectedDate = remember { mutableStateOf("") }
    val barGraphData = listOf(
        BarChartData.Bar(label = "Utilities", value = 50f, color = BarGraphColor),
        BarChartData.Bar(label = "Airtime", value = 30f, color = BarGraphColor),
        BarChartData.Bar(label = "Internet", value = 30f, color = BarGraphColor)
    )
    val dataPoints = listOf(
        LineChartData.Point(1f, "Label 1"),
        LineChartData.Point(2f, "Label 2"),
        LineChartData.Point(3f, "Label 3"),
        LineChartData.Point(4f, "Label 4"),
    )
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {


        Text(text = "Analytics", fontWeight = FontWeight.W700, color = Color.Gray)
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
                detail = "800000",
                icon = Icons.Outlined.Info
            )

            SummaryCard(
                title = "Transactions",
                detail = "300",
                icon = Icons.Outlined.Info
            )
        }



        Spacer(modifier = Modifier.height(30.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            BarGraph(
                title = "Transactions",
                data = barGraphData,
                showDateRange = true
            )
            Spacer(modifier = Modifier.height(10.dp))

            BarGraph(
                title = "Categories",
                data = barGraphData,
                showDateRange = false
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomCard {
                Text(
                    text = "Transaction Types",
                    fontWeight = FontWeight.W700,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(20.dp)
                )

                Row (modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)){
                    LegendItem(color = PieColor1, label = "MTN")
                }

                PieChart(
                    modifier = Modifier.padding(50.dp),
                    pieChartData = PieChartData(
                        listOf(
                            PieChartData.Slice(value = 60F, color = PieColor1),
                            PieChartData.Slice(value = 10F, color = PieColor2),
                            PieChartData.Slice(value = 40F, color = PieColor3),
                        )
                    ), sliceDrawer = SimpleSliceDrawer(
                        sliceThickness = 80F
                    )
                )


            }

        }


    }
}
