package com.konrad.intership12026.feature.homepage.model

sealed interface HomePageIntent {

    data object NavigateToMealPlanner: HomePageIntent
    data object NavigateToMarketMap: HomePageIntent
    data object NavigateToProfile: HomePageIntent

}