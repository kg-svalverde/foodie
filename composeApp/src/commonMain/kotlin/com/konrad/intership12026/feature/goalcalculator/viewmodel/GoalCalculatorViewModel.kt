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

    private val _viewState = MutableStateFlow(GoalCalculatorState(""))
    val viewState = _viewState.asStateFlow()

    private val _event = Channel<GoalCalculatorEvent>()
    val event = _event.receiveAsFlow()

    init {
        fetchSample()
    }

    fun handleIntent(intent: GoalCalculatorIntent) {
        when (intent) {
            is GoalCalculatorIntent.NavigateToMealPlanner -> emitNavigationEvent(NavDestination.MealPlanner)
            is GoalCalculatorIntent.NavigateToMarketMap -> emitNavigationEvent(NavDestination.MarketMap)
            is GoalCalculatorIntent.NavigateToProfile -> emitNavigationEvent(NavDestination.Profile)
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