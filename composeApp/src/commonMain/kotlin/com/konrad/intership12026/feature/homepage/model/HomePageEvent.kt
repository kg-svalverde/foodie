package com.konrad.intership12026.feature.homepage.model

import com.konrad.intership12026.navigation.destination.NavDestination


sealed interface HomePageEvent {

    data class NavigateTo(val destination: NavDestination): HomePageEvent
}