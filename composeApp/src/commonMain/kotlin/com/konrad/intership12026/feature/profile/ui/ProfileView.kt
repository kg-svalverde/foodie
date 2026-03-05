package com.konrad.intership12026.feature.profile.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.konrad.intership12026.feature.initialsetup.model.InitialSetupEvent
import com.konrad.intership12026.feature.profile.model.ProfileEvent
import com.konrad.intership12026.feature.profile.model.ProfileIntent
import com.konrad.intership12026.feature.profile.model.ProfileState
import com.konrad.intership12026.feature.profile.viewmodel.ProfileViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProfileView(
    navBackStack: NavBackStack<NavKey>,
    viewModel: ProfileViewModel = koinViewModel()
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect {
            when (it) {
                is ProfileEvent.NavigateTo -> navBackStack.add(it.destination)
            }
        }
    }

    ProfileLayout(
        viewState = viewState,
        onEditProfileClick = { viewModel.handleIntent(ProfileIntent.NavigateToInitialSetup) }
    )
}