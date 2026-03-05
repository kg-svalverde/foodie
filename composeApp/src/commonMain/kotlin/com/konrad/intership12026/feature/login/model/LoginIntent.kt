package com.konrad.intership12026.feature.login.model

import com.konrad.intership12026.data.UserModel
import com.konrad.intership12026.feature.selectuser.model.SelectUserIntent

sealed class LoginIntent {

    data class EmailChanged(val email: String) : LoginIntent()
    data class PasswordChanged(val password: String) : LoginIntent()
    data object LoginClicked : LoginIntent()
    data object SignUpClicked : LoginIntent()
}