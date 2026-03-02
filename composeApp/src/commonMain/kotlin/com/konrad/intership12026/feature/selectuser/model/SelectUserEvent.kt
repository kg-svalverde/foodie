package com.konrad.intership12026.feature.selectuser.model

import com.konrad.intership12026.navigation.destination.NavDestination


sealed interface SelectUserEvent {

    data class NavigateTo(val destination: NavDestination): SelectUserEvent
}