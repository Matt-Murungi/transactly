package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.myapplication.ui.AppViewModel
import com.example.myapplication.ui.components.ListTile
import com.example.myapplication.ui.components.UniversityDialog

@Composable
fun HomeScreen(navController: NavController, viewModel: AppViewModel) {
    val universities by viewModel.universities.collectAsState()
    var isDialog = remember {
        mutableStateOf(false)
    }

    Surface(modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
        Column {


            Text(text = "All Universities", fontSize = 30.sp)
            Spacer(modifier = Modifier.height(30.dp))

            if (universities.isEmpty()) {
                CircularProgressIndicator()
            } else {
                LazyColumn() {
                    items(universities) { university ->
                        ListTile(
                            icon = Icons.Rounded.AccountBox,
                            label = "${university.name}",
                            onClick = {
                                viewModel.setCurrentSelectedUniversity(university)
                                isDialog.value = true

                            })
                        Spacer(modifier = Modifier.height(13.dp))
                    }

                }
            }

            if (isDialog.value) {
                UniversityDialog(
                    university = viewModel.getCurrentSelectedUniversity(),
                    onDismissRequest = {
                        isDialog.value = false

                    })
            } else {

            }


        }
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Surface(modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)) {
        Dialog(onDismissRequest = { }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "University Name",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Uganda",
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
                        text = "www.www.com",
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
                        text = "http.www.com",
                        modifier = Modifier
                    )
                }
            }
        }
    }

}