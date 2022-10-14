

package com.example.bellapp5.ui
/*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
//import com.example.android.unscramble.ui.GameUiState

import com.example.bellapp5.data.SCORE_INCREASE
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update



class GameViewModel : ViewModel() {

    // Game UI state
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    var userGuess by mutableStateOf("")
        private set

    // Set of words used in the game
    private var usedWords: MutableSet<String> = mutableSetOf()
    private lateinit var currentWord: String


    /*
     * Update the user's guess
     *//*
    fun updateUserGuess(guessedWord: String) {
        userGuess = guessedWord
    }*/

    /*
     * Checks if the user's guess is correct.
     * Increases the score accordingly.
     */
    fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            // User's guess is correct, increase the score
            // and call updateGameState() to prepare the game for next round
           // val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
           // updateGameState(updatedScore)
            val count = 0

        } else {
            // User's guess is wrong, show an error
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
        // Reset user guess
       // updateUserGuess("")
    }


    /*
     * Picks a new currentWord and currentScrambledWord and updates UiState according to
     * current game state.
     *//*
    private fun updateGameState(updatedScore: Int) {
        // if (usedWords.size == MAX_NO_OF_WORDS){
        //Last round in the game, update isGameOver to true, don't pick a new word
        _uiState.update { currentState ->
            currentState.copy(
                isGuessedWordWrong = false,
                // currentWordCount = currentState.currentWordCount.inc(),
                score = updatedScore,
                //  isGameOver = true
            )
        }
        //  } */
        /*  else
    {
        // Normal round in the game
        _uiState.update { currentState ->
            currentState.copy(
                isGuessedWordWrong = false,
                currentScrambledWord = pickRandomWordAndShuffle(),
                // currentWordCount = currentState.currentWordCount.inc(),
                score = updatedScore
            )
        }
        //  }
    }*/
    }
//}
*/
