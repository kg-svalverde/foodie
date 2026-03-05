package com.konrad.intership12026.feature.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konrad.intership12026.data.AppData
import com.konrad.intership12026.feature.profile.model.ProfileEvent
import com.konrad.intership12026.feature.profile.model.ProfileIntent
import com.konrad.intership12026.feature.profile.model.ProfileState
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
class ProfileViewModel() : ViewModel() {

    private val _viewState = MutableStateFlow(ProfileState())
    val viewState = _viewState.asStateFlow()

    private val _event = Channel<ProfileEvent>()
    val event = _event.receiveAsFlow()

    init {
        observeData()
    }

    private fun observeData() {
        AppData.currentUser.onEach { user ->
            _viewState.update { it.copy(user = user) }
        }.launchIn(viewModelScope)
    }

    fun handleIntent(intent: ProfileIntent) {
        when (intent) {
            is ProfileIntent.NavigateToInitialSetup -> emitNavigationEvent(NavDestination.InitialSetup)
        }
    }

    private fun emitNavigationEvent(destination: NavDestination) {
        viewModelScope.launch {
            _event.send(ProfileEvent.NavigateTo(destination))
        }
    }
}
