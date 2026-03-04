package com.konrad.intership12026.feature.goalcalculator.model

data class GoalCalculatorState(
    val age: Float,
    val height: Int,    // cm
    val weight: Float,    // kg
    val activityLevel: String,
    val healthGoal: String,
    val dailyCalories: Int,
    val proteinGrams: Int,
    val carbGrams: Int,
    val fatGrams: Int
)