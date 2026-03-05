package com.konrad.intership12026.feature.selectuser.model

sealed interface SelectUserIntent {

    data object NavigateToHomePage: SelectUserIntent

}