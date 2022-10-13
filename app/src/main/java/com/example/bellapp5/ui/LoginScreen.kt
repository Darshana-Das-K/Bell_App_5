package com.example.bellapp5.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bellapp5.R


@Composable

fun LoginScreen(
    onLoginButtonClicked: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    verticalArrangement = Arrangement.Center
    ) {
        Title()
        Username()
        Password()
        LoginButton(onClick = onLoginButtonClicked )
    }

}
@Composable
fun Title(
) {
    Text(
        text = stringResource(R.string.title_sign_in_screen),
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
    )
    Spacer(modifier = Modifier.height(24.dp))

}

@Composable
fun Username() {
    val usernameState = remember { mutableStateOf(TextFieldValue()) }
    OutlinedTextField(
        value = usernameState.value ,
        onValueChange = { usernameState.value = it },
        modifier = Modifier
            .fillMaxWidth(),
        label = { Text(text = stringResource(R.string.username_label))},
        singleLine = true,
    )
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun Password() {
    //val showPassword = remember { mutableStateOf(false) }
    val passwordState = remember { mutableStateOf(TextFieldValue()) }
    OutlinedTextField(
        value = passwordState.value ,
        onValueChange = { passwordState.value = it },
        modifier = Modifier
            .fillMaxWidth(),
        label = { Text(text = stringResource(R.string.password_label)) },
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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
