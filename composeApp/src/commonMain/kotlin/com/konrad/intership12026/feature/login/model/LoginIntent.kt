package com.konrad.intership12026.feature.login.model

sealed interface LoginIntent {

    data object NavigateToInitialSetup: LoginIntent
    data object NavigateToSelectUser: LoginIntent

}