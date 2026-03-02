package com.konrad.intership12026.feature.mealplanner.model

sealed interface MealPlannerIntent {

    data object NavigateToProfile: MealPlannerIntent

}