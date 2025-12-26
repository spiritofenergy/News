package com.kodex.news.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kodex.news.presentation.screen.LoginScreen
import com.kodex.news.presentation.screen.MainScreen
import com.kodex.news.presentation.screen.RegisterScreen
import kotlinx.coroutines.flow.combine
import kotlinx.serialization.Serializable

sealed class Screen {

    @Serializable
    data object Login: Screen()
    @Serializable
    data object Register: Screen()
    @Serializable
    data object Main: Screen()
}
@Composable
 fun MainNav (
     modifier: Modifier = Modifier,
     navHostController: NavHostController
 ){
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screen.Login
    ) {
        composable<Screen.Login> {
            LoginScreen(
               onNavigateTo = {navigateYTo ->
                navHostController.navigate(navigateYTo)
                 }
            )
        }
        composable<Screen.Register> {
            RegisterScreen { navigateYTo ->
                navHostController.navigate(navigateYTo)

            }
        }
        composable<Screen.Main> {
            MainScreen { navigateYTo ->
                navHostController.navigate(navigateYTo)

            }
        }
    }
}