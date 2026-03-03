package com.konrad.intership12026.feature.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konrad.intership12026.feature.login.model.LoginEvent
import com.konrad.intership12026.feature.login.model.LoginIntent
import com.konrad.intership12026.feature.login.model.LoginState
import com.konrad.intership12026.navigation.destination.NavDestination
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class LoginViewModel(
    //private val useCase: SampleUseCase,
): ViewModel() {

    private val _viewState = MutableStateFlow(LoginState(""))
    val viewState = _viewState.asStateFlow()

    private val _event = Channel<LoginEvent>()
    val event = _event.receiveAsFlow()

    init {
        fetchSample()
    }

    fun handleIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.NavigateToInitialSetup -> emitNavigationEvent(NavDestination.InitialSetup)
            is LoginIntent.NavigateToSelectUser -> emitNavigationEvent(NavDestination.SelectUser)
        }
    }

    private fun emitNavigationEvent(destination: NavDestination) {
        viewModelScope.launch {
            _event.send(LoginEvent.NavigateTo(destination))
        }
    }

    private fun fetchSample() {
        viewModelScope.launch {
            /*useCase.fetchSample()
                .onSuccess { data ->
                    _viewState.update { it.copy(information = data) }
                }
                .onFailure {
                    println("Error $it")
                }*/
        }
    }
}