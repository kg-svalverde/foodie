package com.konrad.intership12026.feature.mealplanner.model

import com.konrad.intership12026.data.RecipeModel

sealed class MealPlannerIntent {
    data class DaySelected(val index: Int) : MealPlannerIntent()
    data class RecipeClicked(val recipe: RecipeModel): MealPlannerIntent()
    data object DismissRecipeDialog : MealPlannerIntent()
}
