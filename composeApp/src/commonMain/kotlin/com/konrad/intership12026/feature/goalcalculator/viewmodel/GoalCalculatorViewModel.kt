package com.konrad.intership12026.feature.goalcalculator.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konrad.intership12026.feature.goalcalculator.model.GoalCalculatorEvent
import com.konrad.intership12026.feature.goalcalculator.model.GoalCalculatorIntent
import com.konrad.intership12026.feature.goalcalculator.model.GoalCalculatorState
import com.konrad.intership12026.navigation.destination.NavDestination
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class GoalCalculatorViewModel(
    //private val useCase: SampleUseCase,
): ViewModel() {

    private val _viewState = MutableStateFlow(GoalCalculatorState(0f,
        0, 0f, "", "", 0, 0, 0, 0))
    val viewState = _viewState.asStateFlow()

    private val _event = Channel<GoalCalculatorEvent>()
    val event = _event.receiveAsFlow()

    init {
        fetchSample()
    }

    fun handleIntent(intent: GoalCalculatorIntent) {
        when (intent) {
            is GoalCalculatorIntent.NavigateToInitialSetup -> emitNavigationEvent(NavDestination.InitialSetup)
            is GoalCalculatorIntent.NavigateToHomePage -> emitNavigationEvent(NavDestination.HomePage)
        }
    }

    private fun emitNavigationEvent(destination: NavDestination) {
        viewModelScope.launch {
            _event.send(GoalCalculatorEvent.NavigateTo(destination))
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