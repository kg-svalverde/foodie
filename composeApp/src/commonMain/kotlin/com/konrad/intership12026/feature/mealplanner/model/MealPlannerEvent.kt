package com.konrad.intership12026.feature.mealplanner.model

import com.konrad.intership12026.navigation.destination.NavDestination


sealed interface MealPlannerEvent {

    data class NavigateTo(val destination: NavDestination): MealPlannerEvent
}