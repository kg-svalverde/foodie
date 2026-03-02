package com.konrad.intership12026.feature.goalcalculator.model

sealed interface GoalCalculatorIntent {

    data object NavigateToMealPlanner: GoalCalculatorIntent
    data object NavigateToMarketMap: GoalCalculatorIntent
    data object NavigateToProfile: GoalCalculatorIntent

}