package com.konrad.intership12026.feature.login.model

import com.konrad.intership12026.navigation.destination.NavDestination


sealed interface LoginEvent {

    data class NavigateTo(val destination: NavDestination): LoginEvent
}