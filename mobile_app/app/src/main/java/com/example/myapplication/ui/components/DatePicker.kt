package com.example.myapplication.ui.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marosseleng.compose.material3.datetimepickers.date.ui.dialog.DatePickerDialog
import java.time.LocalDate


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DatePickerComposable(
    showDialog: Boolean,
    title: String, onDismiss: () -> Unit,
    onDateChange: (LocalDate) -> Unit ,
) {
    if (showDialog) {
        DatePickerDialog(

            onDismissRequest = { onDismiss() }, onDateChange = {
                onDateChange(it)


            }, title = {
                Text(text = title)
            })

    }
}

@Composable
fun DatePickerCard(title: String, onClick: ()-> Unit){
    Box(
        modifier = Modifier.clickable {onClick() },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(horizontal = 5.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.DateRange,
                contentDescription = "",
                modifier = Modifier.padding(10.dp)
            )
            Text(text = title)

        }
    }}