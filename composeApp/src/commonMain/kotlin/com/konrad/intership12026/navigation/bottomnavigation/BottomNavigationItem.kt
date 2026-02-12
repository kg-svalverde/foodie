package com.konrad.intership12026.navigation.bottomnavigation

import com.konrad.intership12026.navigation.RootRoutes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class BottomNavigationItem(
    val label: StringResource,
    val icon: DrawableResource,
    val route: RootRoutes
)