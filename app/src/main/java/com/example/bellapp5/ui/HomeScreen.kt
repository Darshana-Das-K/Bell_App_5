package com.example.bellapp5.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bellapp5.R
@Preview( showSystemUi = true)
@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        AccountInfo()
        DateBookingButton()
        HistoryButton()
    }
}
@Composable
fun AccountInfo(
  //  name: String
) {
    Card(
        modifier = Modifier
        .fillMaxWidth()
    ) {
        Text(
            text = "Name",
            fontSize = 32.sp,
            modifier = Modifier.padding(16.dp)
        )
    }

}

@Composable
fun DateBookingButton() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Book",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun HistoryButton() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),

    ) {
        Text(
            text = "History",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}




