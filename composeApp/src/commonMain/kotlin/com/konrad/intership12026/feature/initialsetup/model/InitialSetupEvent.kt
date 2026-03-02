package com.konrad.intership12026.feature.initialsetup.model

import com.konrad.intership12026.navigation.destination.NavDestination


sealed interface InitialSetupEvent {

    data class NavigateTo(val destination: NavDestination): InitialSetupEvent
}