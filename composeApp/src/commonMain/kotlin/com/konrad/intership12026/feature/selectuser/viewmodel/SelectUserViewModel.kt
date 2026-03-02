package com.konrad.intership12026.feature.selectuser.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konrad.intership12026.feature.selectuser.model.SelectUserEvent
import com.konrad.intership12026.feature.selectuser.model.SelectUserIntent
import com.konrad.intership12026.feature.selectuser.model.SelectUserState
import com.konrad.intership12026.navigation.destination.NavDestination
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class SelectUserViewModel(
    //private val useCase: SampleUseCase,
): ViewModel() {

    private val _viewState = MutableStateFlow(SelectUserState(""))
    val viewState = _viewState.asStateFlow()

    private val _event = Channel<SelectUserEvent>()
    val event = _event.receiveAsFlow()

    init {
        fetchSample()
    }

    fun handleIntent(intent: SelectUserIntent) {
        when (intent) {
            is SelectUserIntent.NavigateToMealPlanner -> emitNavigationEvent(NavDestination.MealPlanner)
            is SelectUserIntent.NavigateToMarketMap -> emitNavigationEvent(NavDestination.MarketMap)
            is SelectUserIntent.NavigateToProfile -> emitNavigationEvent(NavDestination.Profile)
        }
    }

    private fun emitNavigationEvent(destination: NavDestination) {
        viewModelScope.launch {
            _event.send(SelectUserEvent.NavigateTo(destination))
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