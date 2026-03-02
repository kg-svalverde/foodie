package com.konrad.intership12026.feature.initialsetup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konrad.intership12026.feature.initialsetup.model.InitialSetupEvent
import com.konrad.intership12026.feature.initialsetup.model.InitialSetupIntent
import com.konrad.intership12026.feature.initialsetup.model.InitialSetupState
import com.konrad.intership12026.navigation.destination.NavDestination
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class InitialSetupViewModel(
    //private val useCase: SampleUseCase,
): ViewModel() {

    private val _viewState = MutableStateFlow(InitialSetupState(""))
    val viewState = _viewState.asStateFlow()

    private val _event = Channel<InitialSetupEvent>()
    val event = _event.receiveAsFlow()

    init {
        fetchSample()
    }

    fun handleIntent(intent: InitialSetupIntent) {
        when (intent) {
            is InitialSetupIntent.NavigateToMealPlanner -> emitNavigationEvent(NavDestination.MealPlanner)
            is InitialSetupIntent.NavigateToMarketMap -> emitNavigationEvent(NavDestination.MarketMap)
            is InitialSetupIntent.NavigateToProfile -> emitNavigationEvent(NavDestination.Profile)
        }
    }

    private fun emitNavigationEvent(destination: NavDestination) {
        viewModelScope.launch {
            _event.send(InitialSetupEvent.NavigateTo(destination))
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