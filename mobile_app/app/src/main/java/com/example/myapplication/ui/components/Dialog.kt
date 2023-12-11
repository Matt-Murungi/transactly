package com.example.myapplication.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.myapplication.ui.theme.PrimaryColor
import com.example.myapplication.ui.theme.Purple40

@Composable
fun ModalDialog(onDismissRequest: () -> Unit,content: @Composable() (ColumnScope.() -> Unit)) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(modifier = Modifier.padding(10.dp), content=content)
         

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DisplayModal(){

    ModalDialog(onDismissRequest ={ }) {
Text(text = "Transaction", fontWeight = FontWeight.W600, modifier = Modifier
    .fillMaxWidth()
    .padding(10.dp), textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Amount", modifier = Modifier.padding(vertical = 10.dp))
        Text(text = "Amount")
        Text(text = "Amount")
        Text(text = "Amount")

 
    }
}
