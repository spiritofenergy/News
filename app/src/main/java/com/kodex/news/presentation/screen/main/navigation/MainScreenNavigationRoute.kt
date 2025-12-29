package com.kodex.news.presentation.screen.main.navigation

import androidx.navigationevent.NavigationEventInput
import kotlinx.serialization.Serializable

interface MainScreenNavigationRoute {

    @Serializable
    data object Feed: MainScreenNavigationRoute

    @Serializable
    data object Profile: MainScreenNavigationRoute
}