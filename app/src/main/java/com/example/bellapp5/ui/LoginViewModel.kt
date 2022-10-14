package com.example.bellapp5.ui

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

private val _uiState = MutableStateFlow(LoginUiState())
// Backing property to avoid state updates from other classes
val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()
//val username :

class LoginViewModel : ViewModel() {
   /* fun checkUsername() {

        if (username.equals("currentWord", ignoreCase = true)) {
        } else {
        }
        // Reset user guess
        username("")
    }
     else
    {
        // User's guess is wrong, show an error
        _uiState.update { currentState ->
            currentState.copy(isWrong = true)
        }
    }*/

    fun checkUsername(
        username: String
    ):Int {
        var count= if (username =="abcd@gmail.com") 0 else 1
        return count

    }



}