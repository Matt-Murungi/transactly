import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.BarGraphColor
import com.example.myapplication.ui.theme.PrimaryColor

@Composable
fun LoadingIndicator(){
Column(
modifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {

    CircularProgressIndicator(color = BarGraphColor)
    Spacer(modifier = Modifier.height(10.dp))
    Text(text = "Compiling data, might take a while ...")
}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DisplayLoadingIndicator(){
    LoadingIndicator()
}