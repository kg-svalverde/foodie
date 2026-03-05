package com.konrad.intership12026.feature.profile.model

sealed interface ProfileIntent {
    // hacerlo class y que pase el user por parametro a initial setup
    data object NavigateToInitialSetup: ProfileIntent
}