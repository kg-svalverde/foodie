package com.konrad.intership12026.feature.selectuser.model

import com.konrad.intership12026.data.UserModel

sealed class SelectUserIntent {

    /*data object NavigateToHomePage: SelectUserIntent()
    data object NavigateToInitialSetup: SelectUserIntent()*/
    data class UserSelected(val user: UserModel) : SelectUserIntent()
    object AddNewUserClicked : SelectUserIntent()

}