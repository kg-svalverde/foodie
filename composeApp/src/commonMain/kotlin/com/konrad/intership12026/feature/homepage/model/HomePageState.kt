package com.konrad.intership12026.feature.homepage.model

import com.konrad.intership12026.components.carrousel.Recipe

data class HomePageState(
    val name: String = "",
    val recipes: List<Recipe> = emptyList()
)