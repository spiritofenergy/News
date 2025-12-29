package com.kodex.news.domain.util

import androidx.compose.ui.graphics.vector.ImageVector
import com.kodex.news.presentation.screen.main.navigation.MainScreenNavigationRoute

class BottomNavItem(
    val icon: ImageVector,
    val titleResId: Int,
    val route: MainScreenNavigationRoute,

) {
}