package com.example.myapplication.ui.components

import android.widget.ListView
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ListTile(
    icon: ImageVector,
    label: String,

    onClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = Modifier
            .clickable {
                onClick()
            }
//            .border(width = 2.dp, color = Color.LightGray)
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 40.dp)


        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = " ",
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(18.dp))

                Column {
                    Text(text = label, style = TextStyle(fontSize = 15.sp))
                    Text(text = "label", style = TextStyle(fontSize = 15.sp))
                }
            }
            Spacer(modifier = Modifier.width(18.dp))

            Text(text = "label", style = TextStyle(fontSize = 15.sp))

        }


    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun displayListView() {
    ListTile(icon = Icons.Outlined.Info, label = "Test Listtile") {

    }
}