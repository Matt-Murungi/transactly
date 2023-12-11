package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NoInternetScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "", tint = Color.Red,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Please Connect To Internet", fontSize = 20.sp, fontWeight = FontWeight.W600)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowNoInternetScreen() {
    NoInternetScreen()
}