package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.PrimaryColor


@Composable
fun BottonNavigationMenu(
    selectedScreen: Int,
    onItemSelected:(Int) -> Unit
){
    NavigationBar(
        containerColor = PrimaryColor
    ) {
        BottomNavItem(isSelected = selectedScreen == 0, route = { onItemSelected(0)}, icon = Icons.Filled.AccountBox, label = "Dashboard")
        BottomNavItem(isSelected = selectedScreen == 1, route = { onItemSelected(1) }, icon = Icons.Filled.Check, label = "History")
        BottomNavItem(isSelected = selectedScreen == 2, route = { onItemSelected(2) }, icon = Icons.Filled.AccountBox, label = "Dashboard")
    }

}

@Composable
fun RowScope.BottomNavItem(
    isSelected: Boolean,
    route: () -> Unit,
    icon: ImageVector,
    label:String
) {


        NavigationBarItem(
            selected = isSelected,
            alwaysShowLabel = true,
            colors = NavigationBarItemDefaults.colors(
                selectedTextColor = Color.Black,
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray,
                indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(8.dp)
            ),
            label = {
                    Text(text = label)
            },
            onClick = route, icon = {
                Icon(
                    imageVector =
                    icon, contentDescription = ""
                )
            },


        )


}