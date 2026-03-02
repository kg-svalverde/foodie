package com.konrad.intership12026.feature.initialsetup.model

sealed interface InitialSetupIntent {

    data object NavigateToMealPlanner: InitialSetupIntent
    data object NavigateToMarketMap: InitialSetupIntent
    data object NavigateToProfile: InitialSetupIntent

}