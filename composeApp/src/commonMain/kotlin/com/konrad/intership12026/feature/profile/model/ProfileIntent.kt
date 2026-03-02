package com.konrad.intership12026.feature.profile.model

sealed interface ProfileIntent {

    data object NavigateToProfile: ProfileIntent

}