package com.konrad.intership12026.feature.profile.model

import com.konrad.intership12026.navigation.destination.NavDestination


sealed interface ProfileEvent {

    data class NavigateTo(val destination: NavDestination): ProfileEvent
}