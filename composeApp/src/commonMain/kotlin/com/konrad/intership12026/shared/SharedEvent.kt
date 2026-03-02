package com.konrad.intership12026.shared

import androidx.navigation3.runtime.NavKey

sealed interface SharedEvent {
    data class NavigateToDestination(val destination: NavKey) : SharedEvent
}