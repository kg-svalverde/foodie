package com.konrad.intership12026.feature.initialsetup.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.konrad.intership12026.feature.initialsetup.model.InitialSetupEvent
import com.konrad.intership12026.feature.initialsetup.model.InitialSetupIntent
import com.konrad.intership12026.feature.initialsetup.viewmodel.InitialSetupViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun InitialSetupView(
    navBackStack: NavBackStack<NavKey>,
    viewModel: InitialSetupViewModel = koinViewModel(),
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect {
            when (it) {
                is InitialSetupEvent.NavigateTo -> navBackStack.add(it.destination)
            }
        }
    }

    InitialSetupLayout(
        viewState = viewState,
        onNameChange = { viewModel.handleIntent(InitialSetupIntent.UpdateName(it)) },
        onButtonClick = { viewModel.handleIntent(InitialSetupIntent.NavigateToProfile) }
    )
}