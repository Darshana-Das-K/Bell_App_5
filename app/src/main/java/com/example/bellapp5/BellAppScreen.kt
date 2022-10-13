package com.example.bellapp5

import android.icu.text.CaseMap.Title
import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.bellapp5.ui.LoginScreen
import com.example.bellapp5.ui.theme.MainScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


enum class BellAppScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Selector(title = R.string.selector),
    Summary(title = R.string.summary)
}


/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@Composable
fun BellAppBar(
    currentScreen: BellAppScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}



@Composable
fun BellApp(

){
    val navController = rememberNavController()
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = BellAppScreen.valueOf(
        backStackEntry?.destination?.route ?: BellAppScreen.Start.name
    )
    Scaffold(
        topBar = {
            BellAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ){
        NavHost(
            navController = navController,
            startDestination = BellAppScreen.Start.name,

        ) {
            composable(route = BellAppScreen.Start.name) {
                LoginScreen()
        }
            composable(route = BellAppScreen.Selector.name) {
                MainScreen()
            }

            }
    }


}




