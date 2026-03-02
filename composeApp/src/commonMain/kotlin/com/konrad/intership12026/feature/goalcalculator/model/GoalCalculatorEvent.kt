package com.konrad.intership12026.feature.goalcalculator.model

import com.konrad.intership12026.navigation.destination.NavDestination


sealed interface GoalCalculatorEvent {

    data class NavigateTo(val destination: NavDestination): GoalCalculatorEvent
}