package com.example.bellapp5.ui

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bellapp5.R

@Preview
@Composable


fun LoginScreen(
    onLoginButtonClicked: () -> Unit = {},
    // @StringRes username : Int
) {

    Box {
        Image(
            painter = painterResource(R.drawable.login_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .blur(
                    radiusX = 5.dp,
                    radiusY = 5.dp,
                    edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(4.dp))
                ),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            //TITLE


            Title()
            Username()
            Password()

            Button(
                onClick = { onLoginButtonClicked() },
                //onClick = {logged(usernameState.value,passwordState.value)} ,
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(16.dp),
                shape = RoundedCornerShape(24.dp)

            ) {
                Text(
                    text = stringResource(R.string.sign_in_button),
                    fontSize = 18.sp
                )
            }

        }
    }

}
/*
@Composable
fun logged(
    username: String, password : String
){
    if ((username=="kkkk@gmail.com")&& (password=="1234"){
        Toast.makeText("Logged In Successfullly")
        }
}
*/


@Composable
fun Title(
) {
    val PlayFair= FontFamily(
        Font(R.font.playfair_display_bold)
    )
    Text(
        text = stringResource(R.string.title_sign_in_screen),
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 70.sp,
        fontFamily = PlayFair

    )
    Spacer(modifier = Modifier.height(24.dp))

}

@Composable
fun Username() {
    val usernameState = remember { mutableStateOf(TextFieldValue()) }

    TextField(
        value = usernameState.value,
        onValueChange = { usernameState.value = it },
        modifier = Modifier
            .fillMaxWidth(),
           // .background(color = Color.Black),
        label = { Text(
            text = stringResource(R.string.username_label),

            color = Color.Gray
        ) },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            disabledLabelColor = Color.Gray,
            cursorColor = Color.Black,


            textColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),


        shape = RoundedCornerShape(8.dp),
        textStyle = TextStyle(fontWeight = FontWeight.Bold,
        fontSize = 20.sp)

    )
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun Password() {
    //val showPassword = remember { mutableStateOf(false) }
    val passwordState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        modifier = Modifier
            .fillMaxWidth(),
           // .background(color = Color.White),
        label = { Text(text = stringResource(R.string.password_label),
            color = Color.Gray) },
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.textFieldColors(
            disabledLabelColor = Color.Gray,
            cursorColor = Color.Black,


            textColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),

        shape = RoundedCornerShape(8.dp),
        textStyle = TextStyle(fontWeight = FontWeight.Bold,
            fontSize = 30.sp)
        /*  trailingIcon = {
              if( showPassword.value ){
                  IconButton(onClick = { /*TODO*/ }) {
                      Icon(
                          painter = painterResource(R.drawable.ic_baseline_visibility_24)
                      )
                  }
              }
          }*/
    )
    Spacer(modifier = Modifier.height(30.dp))
}
/*
@Composable
fun LoginButton(
    onClick: () -> Unit = {},
) {
    Button(
        onClick = { onClick },
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(16.dp),
        shape = RoundedCornerShape(24.dp)

    ) {
        Text(
            text = stringResource(R.string.sign_in_button),
            fontSize = 18.sp
        )
    }


}

*/