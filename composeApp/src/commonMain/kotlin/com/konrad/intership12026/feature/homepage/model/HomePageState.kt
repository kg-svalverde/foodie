package com.konrad.intership12026.feature.homepage.model

import com.konrad.intership12026.data.RecipeModel
import com.konrad.intership12026.data.UserModel

data class HomePageState(
    val user: UserModel? = null,
    val recipes: List<RecipeModel> = emptyList()
)
