package com.konrad.intership12026.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class RootRoutes {
    @Serializable
    object Home : RootRoutes()

    @Serializable
    object SampleNested : RootRoutes()
}