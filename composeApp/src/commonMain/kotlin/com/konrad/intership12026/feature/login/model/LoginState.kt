package com.konrad.intership12026.feature.login.model

data class LoginState(
    val email: String = "",
    val password: String = "",
    val errorMessage: String? = null,
)