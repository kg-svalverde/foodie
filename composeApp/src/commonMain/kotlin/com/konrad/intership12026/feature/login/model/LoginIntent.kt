package com.konrad.intership12026.feature.login.model

sealed interface LoginIntent {

    data object NavigateToMealPlanner: LoginIntent
    data object NavigateToMarketMap: LoginIntent
    data object NavigateToProfile: LoginIntent

}