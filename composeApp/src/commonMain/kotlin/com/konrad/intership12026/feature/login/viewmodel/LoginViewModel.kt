package com.konrad.intership12026.feature.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konrad.intership12026.data.AppData
import com.konrad.intership12026.feature.login.model.LoginEvent
import com.konrad.intership12026.feature.login.model.LoginIntent
import com.konrad.intership12026.feature.login.model.LoginState
import com.konrad.intership12026.navigation.destination.NavDestination
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class LoginViewModel : ViewModel() {

    // FIX: Initialize with default empty state, not a string ""
    private val _viewState = MutableStateFlow(LoginState())
    val viewState = _viewState.asStateFlow()

    private val _event = Channel<LoginEvent>()
    val event = _event.receiveAsFlow()

    fun handleIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.EmailChanged -> {
                _viewState.update { it.copy(email = intent.email, errorMessage = null) }
            }
            is LoginIntent.PasswordChanged -> {
                _viewState.update { it.copy(password = intent.password, errorMessage = null) }
            }
            is LoginIntent.LoginClicked -> {
                login()
            }
            is LoginIntent.SignUpClicked -> {
                emitNavigationEvent(NavDestination.InitialSetup)
            }
        }
    }

    private fun login() {
        val currentState = _viewState.value

        val userExists = AppData.users.any {
            it.email == currentState.email && it.password == currentState.password
        }

        if (userExists) {
            emitNavigationEvent(NavDestination.SelectUser)
        } else {
            _viewState.update {
                it.copy(errorMessage = "Incorrect email or password")
            }
        }
    }

    private fun emitNavigationEvent(destination: NavDestination) {
        viewModelScope.launch {
            _event.send(LoginEvent.NavigateTo(destination))
        }
    }
}