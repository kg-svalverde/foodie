package com.konrad.intership12026.feature.marketmap.model

import com.konrad.intership12026.navigation.destination.NavDestination


sealed interface MarketMapEvent {
    data class NavigateTo(val destination: NavDestination): MarketMapEvent

}