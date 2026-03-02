package com.konrad.intership12026.feature.selectuser.model

sealed interface SelectUserIntent {

    data object NavigateToMealPlanner: SelectUserIntent
    data object NavigateToMarketMap: SelectUserIntent
    data object NavigateToProfile: SelectUserIntent

}