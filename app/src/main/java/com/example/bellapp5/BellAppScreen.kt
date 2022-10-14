package com.example.bellapp5

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bellapp5.ui.HomeScreen
import com.example.bellapp5.ui.LoginScreen
import com.example.bellapp5.ui.LoginViewModel
import com.example.bellapp5.ui.MainScreen

//import com.example.bellapp5.ui.OrderViewModel


enum class BellAppScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Home(title = R.string.home),
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
    modifier: Modifier = Modifier,

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
    viewModel: LoginViewModel = viewModel(),
    modifier: Modifier,
    navController: NavHostController = rememberNavController()

) {
    val navController = rememberNavController()
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    var count: Int
    val currentScreen = BellAppScreen.valueOf(
        backStackEntry?.destination?.route ?: BellAppScreen.Start.name
    )
    Scaffold(
        topBar = {
            BellAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                modifier = Modifier.background(Color(0xFF142685))
            )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = BellAppScreen.Start.name,

            ) {
            composable(route = BellAppScreen.Start.name) {
                LoginScreen(
                    onLoginButtonClicked = {

                        navController.navigate(BellAppScreen.Selector.name)
                    }
                )
            }
         /*   composable(route = BellAppScreen.Home.name) {
                HomeScreen()

            }*/
            composable(route = BellAppScreen.Selector.name) {
                MainScreen()

            }

        }
    }


}




