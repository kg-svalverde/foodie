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
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class InitialSetupViewModel : ViewModel() {

    private val _viewState = MutableStateFlow(InitialSetupState())
    val viewState = _viewState.asStateFlow()

    private val _event = Channel<InitialSetupEvent>()
    val event = _event.receiveAsFlow()

    fun handleIntent(intent: InitialSetupIntent) {
        when (intent) {
            is InitialSetupIntent.UpdateName -> {
                _viewState.update { it.copy(name = intent.name) }
            }
            is InitialSetupIntent.UpdateDietaryPreference -> {
                _viewState.update { it.copy(dietaryPreference = intent.preference) }
            }
            is InitialSetupIntent.AddAllergy -> {
                _viewState.update { 
                    if (!it.allergies.contains(intent.allergy)) {
                        it.copy(allergies = it.allergies + intent.allergy)
                    } else it
                }
            }
            is InitialSetupIntent.RemoveAllergy -> {
                _viewState.update { 
                    it.copy(allergies = it.allergies - intent.allergy)
                }
            }
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
}
