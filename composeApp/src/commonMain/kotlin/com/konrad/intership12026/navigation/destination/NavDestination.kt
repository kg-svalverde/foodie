package com.konrad.intership12026.navigation.destination

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavDestination : NavKey {

    @Serializable
    data object Login : NavDestination

    @Serializable
    data object InitialSetup : NavDestination

    @Serializable
    data object GoalCalculator : NavDestination

    @Serializable
    data object SelectUser : NavDestination

    @Serializable
    data object HomePage : NavDestination

    @Serializable
    data object MealPlanner : NavDestination

    @Serializable
    data object MarketMap : NavDestination

    @Serializable
    data object Profile: NavDestination
}