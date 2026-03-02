package com.konrad.intership12026.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.konrad.intership12026.feature.goalcalculator.ui.GoalCalculatorView
import com.konrad.intership12026.feature.homepage.ui.HomePageView
import com.konrad.intership12026.feature.initialsetup.ui.InitialSetupView
import com.konrad.intership12026.feature.login.ui.LoginView
import com.konrad.intership12026.feature.marketmap.ui.MarketMapView
import com.konrad.intership12026.feature.mealplanner.ui.MealPlannerView
import com.konrad.intership12026.feature.profile.ui.ProfileView
import com.konrad.intership12026.feature.selectuser.ui.SelectUserView
import com.konrad.intership12026.navigation.destination.NavDestination
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

private val config = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(NavDestination.Login::class, NavDestination.Login.serializer())
            subclass(NavDestination.HomePage::class, NavDestination.HomePage.serializer())
            subclass(NavDestination.InitialSetup::class, NavDestination.InitialSetup.serializer())
            subclass(NavDestination.GoalCalculator::class, NavDestination.GoalCalculator.serializer())
            subclass(NavDestination.SelectUser::class, NavDestination.SelectUser.serializer())
            subclass(NavDestination.MealPlanner::class, NavDestination.MealPlanner.serializer())
            subclass(NavDestination.MarketMap::class, NavDestination.MarketMap.serializer())
            subclass(NavDestination.Profile::class, NavDestination.Profile.serializer())
        }
    }
}

@Composable
fun MainNavHost() {
    val navBackStack = rememberNavBackStack(config, NavDestination.Login)

    Scaffold { innerPadding ->
        NavDisplay(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            backStack = navBackStack,
            entryProvider = entryProvider {
                /* Login & User */
                entry<NavDestination.Login> { LoginView(navBackStack) }
                entry<NavDestination.InitialSetup> { InitialSetupView(navBackStack) }
                entry<NavDestination.GoalCalculator> { GoalCalculatorView(navBackStack) }
                entry<NavDestination.SelectUser> { SelectUserView(navBackStack) }
                /* Functionalities */
                entry<NavDestination.HomePage> { HomePageView(navBackStack) }
                entry<NavDestination.MealPlanner> { MealPlannerView(navBackStack) }
                entry<NavDestination.MarketMap> { MarketMapView(navBackStack) }
                entry<NavDestination.Profile> { ProfileView(navBackStack) }
            }
        )
    }
}