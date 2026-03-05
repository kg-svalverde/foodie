package com.konrad.intership12026.feature.homepage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konrad.intership12026.data.AppData
import com.konrad.intership12026.feature.homepage.model.HomePageEvent
import com.konrad.intership12026.feature.homepage.model.HomePageIntent
import com.konrad.intership12026.feature.homepage.model.HomePageState
import com.konrad.intership12026.navigation.destination.NavDestination
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class HomePageViewModel() : ViewModel() {
    private val _viewState = MutableStateFlow(
        HomePageState()
    )
    val viewState = _viewState.asStateFlow()

    private val _event = Channel<HomePageEvent>()
    val event = _event.receiveAsFlow()

    init {
        observeData()
    }

    private fun observeData() {
        AppData.currentUser.onEach { user ->
            _viewState.update { it.copy(user = user) }
        }.launchIn(viewModelScope)

        _viewState.update { it.copy(recipes = AppData.recipes) }
    }

    fun handleIntent(intent: HomePageIntent) {
        when (intent) {
            is HomePageIntent.RecipeClicked -> emitNavigationEvent(NavDestination.MealPlanner)
            is HomePageIntent.NavigateToProfile -> emitNavigationEvent(NavDestination.Profile)
        }
    }

    private fun emitNavigationEvent(destination: NavDestination) {
        viewModelScope.launch {
            _event.send(HomePageEvent.NavigateTo(destination))
        }
    }
}
