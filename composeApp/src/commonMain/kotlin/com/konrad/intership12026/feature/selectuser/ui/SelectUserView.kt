package com.konrad.intership12026.feature.selectuser.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.konrad.intership12026.feature.selectuser.model.SelectUserEvent
import com.konrad.intership12026.feature.selectuser.model.SelectUserIntent
import com.konrad.intership12026.feature.selectuser.viewmodel.SelectUserViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SelectUserView(
    navBackStack: NavBackStack<NavKey>,
    viewModel: SelectUserViewModel = koinViewModel(),
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect {
            when (it) {
                is SelectUserEvent.NavigateTo -> navBackStack.add(it.destination)
            }
        }
    }

    SelectUserLayout(
        viewState = viewState,
        onButtonClick = { viewModel.handleIntent(SelectUserIntent.NavigateToProfile) }
    )
}