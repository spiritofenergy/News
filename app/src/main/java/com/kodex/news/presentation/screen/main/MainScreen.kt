package com.kodex.news.presentation.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kodex.news.presentation.navigation.Screen
import com.kodex.news.presentation.screen.main.feed.FeedScreen
import com.kodex.news.presentation.screen.main.navigation.BottomNavigationBar
import com.kodex.news.presentation.screen.main.navigation.MainScreenNavigationRoute
import com.kodex.news.presentation.screen.main.profile.ProfileScreen

@Composable
fun MainScreen(
    onNavigate: (Screen) -> Unit
) {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController)
        }){
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = MainScreenNavigationRoute.Feed

        ) {
            composable <MainScreenNavigationRoute.Feed>{
                FeedScreen()
            }
            composable <MainScreenNavigationRoute.Profile>{
                ProfileScreen()
            }

        }
    }
}