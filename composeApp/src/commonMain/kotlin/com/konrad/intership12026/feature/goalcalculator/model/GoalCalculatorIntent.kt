package com.konrad.intership12026.feature.goalcalculator.model

sealed interface GoalCalculatorIntent {

    data object NavigateToInitialSetup: GoalCalculatorIntent
    data object NavigateToHomePage: GoalCalculatorIntent

}