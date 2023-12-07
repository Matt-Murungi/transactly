package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.myapplication.models.UniversityModelItem

@Composable
fun UniversityDialog(onDismissRequest: () -> Unit, university: UniversityModelItem?) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "${university?.name}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${university?.country}",
                    modifier = Modifier,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(20.dp))

                Divider()
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Domains",
                    modifier = Modifier,
                    fontWeight = FontWeight.W400,
                    fontSize = 15.sp,

                    )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "${university?.domains}",
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Web Pages",
                    modifier = Modifier,
                    fontWeight = FontWeight.W400,
                    fontSize = 15.sp,
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "${university?.web_pages}"
                )
            }
        }
    }
}