package com.example.myapplication.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.Purple40

@Composable
fun SummaryCard(
    title: String,
    subtitle: String = "",
    detail: String,
    icon: ImageVector

){
    Card (colors = CardDefaults.cardColors(Color.White),
modifier = Modifier.border(width = 0.9.dp, color = Color.LightGray, shape = RoundedCornerShape(5.dp))
        ){
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(20.dp),

            ) {
            Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.W600, color = Color.Gray)
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (subtitle.isNotBlank()) {
                    if(subtitle.isNotBlank()){
                        Text(text = subtitle, fontSize = 10.sp, fontWeight = FontWeight.W700, color = Color.Green)
                        Spacer(modifier = Modifier.height(3.dp))

                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = detail, fontSize = 25.sp, fontWeight = FontWeight.W600, color=Color.DarkGray)

            }

        }
    }
}


@Composable
fun CustomCard(
    content: @Composable() (ColumnScope.() -> Unit)
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
        content = content
    )
}