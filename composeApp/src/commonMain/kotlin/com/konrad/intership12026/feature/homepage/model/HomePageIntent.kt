package com.konrad.intership12026.feature.homepage.model

import com.konrad.intership12026.data.RecipeModel

sealed class HomePageIntent {
    data object NavigateToProfile: HomePageIntent()
    data class RecipeClicked(val recipe: RecipeModel): HomePageIntent()
}
