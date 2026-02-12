package com.konrad.intership12026.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.konrad.intership12026.feature.homepage.ui.HomePageView
import com.konrad.intership12026.navigation.RootRoutes
import kotlinx.serialization.Serializable

fun NavGraphBuilder.homePageGraph(navController: NavController) {
    navigation<RootRoutes.Home>(startDestination = HomePageRoutes.HomePage) {
        composable<HomePageRoutes.HomePage> {
            HomePageView()
        }
    }
}

@Serializable
sealed class HomePageRoutes {
    @Serializable
    object HomePage : HomePageRoutes()
}