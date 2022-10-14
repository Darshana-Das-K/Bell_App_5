package com.example.bellapp5.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bellapp5.R
import com.example.bellapp5.data.DateData
import com.example.bellapp5.data.dateList
var numberOfMeal: Int = 0

//@Preview(showSystemUi = true)
@Composable
fun MainScreen() {
    Calender()
    DueCard()

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Calender() {
    val number: Int
    val PlayFair = FontFamily(
        Font(R.font.playfair_display_bold)
    )

    LazyColumn(
        modifier = Modifier
    ) {
        stickyHeader {
            Text(
                text = "Total Amount: ",
                fontFamily = PlayFair,
                style = MaterialTheme.typography.h1,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    //.padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.primary),
                color = Color.White,
                textAlign = TextAlign.Center
            )

        }
        items(dateList) {
            CalenderList(date = it)
        }

    }
}

@Composable
fun CalenderList(
    date: DateData,
    modifier: Modifier = Modifier
        .animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow

            )
        ),
  //  checked : Boolean


) {
    val number: Int
    var expanded by remember { mutableStateOf(false) }
    var checked by remember { mutableStateOf(false) }
    val onCheckedChange: (Boolean) -> Unit = { value -> checked = value }
    val isChecked = rememberSaveable{ mutableStateOf(false) }


    //val count: Int
    //checkedState.value = checked


    Card(
        modifier = Modifier.padding(8.dp),
        elevation = 8.dp
    ) {

        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                CheckBox(
                    checked,
                    onCheckedChange,
                    modifier = Modifier.weight(1f),
                )
                if(checked==true ){
                    numberOfMeal++
                }

                Row(
                    modifier = Modifier.weight(9f)
                ) {
                    DateCard(date.date)
                }


                Row(
                    modifier = Modifier.weight(1f)
                ) {
                    DisplayTimeButton(
                        expanded = expanded,
                        onClick = { expanded = !expanded }
                    )
                }

            }
            if (expanded) {
                MealCourse()

            }
        }
    }
}
@Composable
fun CheckBox(
    isChecked: Boolean,
    onChange: (Boolean) -> Unit,
    modifier: Modifier
){
    Checkbox(
        checked = isChecked,
        onCheckedChange = onChange,


        )
}
/*
fun checking(value: Boolean) {
    var numberCheckboxes : Int =0
    if (value){
        numberCheckboxes++
    }
}
*/
@Composable
fun MealCourse(

) {

    val checkedState1 = remember { mutableStateOf(false) }
    val checkedState2 = remember { mutableStateOf(false) }
    val checkedState3 = remember { mutableStateOf(false) }
    Column() {
        // BreakFast
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            elevation = 4.dp,


        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(
                    checked = checkedState1.value,
                    onCheckedChange = { checkedState1.value = it },
                    modifier = Modifier.weight(1f),
                    colors = CheckboxDefaults.colors(Color(0xFF142685))
                )
                Text(
                    text = "Breakfast",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .weight(10f)
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
        // Lunch
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 4.dp

            ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(
                    checked = checkedState2.value,
                    onCheckedChange = { checkedState2.value = it },
                    modifier = Modifier.weight(1f),
                    colors = CheckboxDefaults.colors(Color(0xFF142685)),

                )

                Text(
                    text = "Lunch",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .weight(10f)
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
        // Dinner
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = 4.dp
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(
                    checked = checkedState3.value,
                    onCheckedChange = { checkedState3.value = it },
                    modifier = Modifier.weight(1f),
                    colors = CheckboxDefaults.colors(Color(0xFF142685))
                )
                Text(
                    text = "Dinner",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .weight(10f)
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }


    }
}


/*
val interactionSource = remember { MutableInteractionSource() }
val isPressed by interactionSource.collectIsPressedAsState()
val color = if (isPressed) Color(0xFF142685) else Color.Black

Button(
    onClick = {},
    interactionSource = interactionSource,
    colors = ButtonDefaults.buttonColors(backgroundColor = color),
    modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)

) {

    Text(
        text = stringResource(course),
        color = Color.White
    )

}
}*/


@Composable
fun DateCard(date: Int) {
    Text(
        text = date.toString(),
        fontSize = 24.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        textAlign = TextAlign.Center
    )


}


@Composable
fun DueCard() {
    Card() {

    }
}


@Composable
fun DisplayTimeButton(expanded: Boolean, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.secondary,
            contentDescription = "Meal Course Selection",


            )
    }
}


@Composable
fun TotalAmount(
    numberOfMeals: Int
){
    var totalAmount :Int
    totalAmount = numberOfMeals * 70
    Text(
        text = "Total Amount:  $totalAmount"
    )
}




