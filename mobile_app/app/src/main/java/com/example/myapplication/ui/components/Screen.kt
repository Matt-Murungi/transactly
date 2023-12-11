package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.PrimaryColor
import com.example.myapplication.ui.theme.ScreenColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(
    bottomBar: @Composable () -> Unit,
    components: @Composable() (ColumnScope.() -> Unit)
) {
    Scaffold(
        containerColor = ScreenColor,

        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(ScreenColor),
                title = { Text(text = "Transactly", fontWeight = FontWeight.W700) },
                actions = {
                    CustomIconButton(icon = Icons.Outlined.Notifications)


                }
            )

        },

        bottomBar = bottomBar,

    ){
        innerPadding ->
        Column(Modifier.padding(innerPadding).padding(horizontal = 20.dp)){
            components()
        }
    }
}