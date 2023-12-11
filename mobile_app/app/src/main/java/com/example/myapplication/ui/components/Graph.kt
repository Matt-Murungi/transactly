package com.example.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.BarGraphColor
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.label.SimpleValueDrawer
import com.github.tehras.charts.bar.renderer.xaxis.SimpleXAxisDrawer
import com.github.tehras.charts.bar.renderer.yaxis.SimpleYAxisDrawer
import com.github.tehras.charts.line.renderer.yaxis.LabelFormatter


var labelFormater: LabelFormatter = {
    "%.0f".format(it)}
@Composable
fun BarGraph(
    title: String,
    showDateRange: Boolean,
    data:  List<BarChartData.Bar>
){


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .border(
                width = 0.9.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            ),
        colors = CardDefaults.cardColors(Color.White),
    ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 14.dp)
            ) {
                if(showDateRange) {

                    Text(text = title, fontWeight = FontWeight.W600, fontSize = 15.sp)
                    Spacer(modifier = Modifier.width(30.dp))
                    DatePickerCard(title = "From", onClick = {})
                    DatePickerCard(title = "To", onClick = {})
                    Spacer(modifier = Modifier.width(30.dp))
                }else{
                    Text(text = title, fontWeight = FontWeight.W600, fontSize = 15.sp)

                }

            }

        BarChart(
            modifier = Modifier.padding(30.dp),
            labelDrawer = SimpleValueDrawer(
                drawLocation = SimpleValueDrawer.DrawLocation.Outside,
                labelTextColor = Color.Gray
            ),
            xAxisDrawer = SimpleXAxisDrawer(
                axisLineThickness = 1.dp,
                axisLineColor = Color.LightGray
            ),
            yAxisDrawer = SimpleYAxisDrawer(
                axisLineThickness = 0.dp,
                labelTextSize = 10.sp,
                labelValueFormatter = labelFormater,
                axisLineColor = Color.LightGray,
                labelTextColor = Color.LightGray,
            ),

            barChartData = BarChartData(

                startAtZero = true,
                bars = data
            )
        )
    }
}

@Composable
fun LegendItem(
    color: Color,
    label:String
    
){
    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(modifier = Modifier
            .width(13.dp)
            .height(13.dp)
            .background(color = color)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            ),){

        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = label)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DisplayBarGraph(){
    val barGraphData = listOf(
        BarChartData.Bar(label = "Utilities", value = 70f, color = Color.Red),
        BarChartData.Bar(label = "Airtime", value = 30f, color = BarGraphColor),
        BarChartData.Bar(label = "Internet", value = 30f, color = BarGraphColor)
    )

    BarGraph(title = "test", showDateRange = true, data = barGraphData )
}