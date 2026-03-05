package com.konrad.intership12026.feature.mealplanner.model

import com.konrad.intership12026.data.RecipeModel
import com.konrad.intership12026.data.UserModel
import com.konrad.intership12026.data.WeeklyPlan

data class MealPlannerState(
    val user: UserModel? = null,
    val weeklyPlan: WeeklyPlan? = null,
    val selectedDayIndex: Int = 0,
    val selectedRecipe: RecipeModel? = null
)
