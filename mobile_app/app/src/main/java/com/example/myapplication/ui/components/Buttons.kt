package com.example.myapplication.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun CustomIconButton(
    icon: ImageVector,

){
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector =icon , contentDescription = "Button")
    }
}