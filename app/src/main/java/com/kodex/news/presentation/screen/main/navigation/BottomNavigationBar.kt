package com.kodex.news.presentation.screen.main.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.kodex.news.R
import com.kodex.news.domain.util.BottomNavItem

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
        val bottomNavItems = listOf(
            BottomNavItem(
                icon = Icons.Outlined.Home,
                titleResId = R.string.feed,
                route = MainScreenNavigationRoute.Feed
            ),

            BottomNavItem(
                icon = Icons.Outlined.Person,
                titleResId = R.string.profile,
                route = MainScreenNavigationRoute.Profile
            ),
        )

    var selectedItemIndex by rememberSaveable{ mutableStateOf(0) }

        NavigationBar(
            containerColor = MaterialTheme.colorScheme.background
        ) {

         bottomNavItems.forEachIndexed { index, item ->
             NavigationBarItem(
                 selected = selectedItemIndex == index,
                 onClick = {
                     selectedItemIndex = index
                     navController.navigate(item.route)
                 },
                 icon = {
                     Icon(
                         imageVector = item.icon,
                         contentDescription = "BottomNavItem icon"
                     )
                 }
             )
         }
    }
}