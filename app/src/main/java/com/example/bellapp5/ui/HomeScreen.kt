package com.example.bellapp5.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bellapp5.R
@Preview( showSystemUi = true)
@Composable
fun HomeScreen(){
    Column {
        Image(
            painter = painterResource(R.drawable.home_bg),
            contentDescription = null,
            modifier = Modifier.weight(2f),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .fillMaxSize()
                .padding(24.dp).weight(1.5f),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {

            AccountInfo(modifier = Modifier.weight(1f))
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
    }
}
@Composable
fun AccountInfo(
  modifier: Modifier
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
fun DateBookingButton(modifier: Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Book",
            fontSize = 32.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}
/*
@Composable
fun HistoryButton(modifier: Modifier) {
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

*/


