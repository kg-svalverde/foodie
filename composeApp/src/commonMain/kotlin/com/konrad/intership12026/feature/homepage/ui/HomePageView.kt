package com.konrad.intership12026.feature.homepage.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.konrad.intership12026.feature.homepage.model.HomePageEvent
import com.konrad.intership12026.feature.homepage.model.HomePageIntent
import com.konrad.intership12026.feature.homepage.viewmodel.HomePageViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomePageView(
    navBackStack: NavBackStack<NavKey>,
    viewModel: HomePageViewModel = koinViewModel(),
) {
    /*val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect {
            when (it) {
                is HomePageEvent.NavigateTo -> navBackStack.add(it.destination)
            }
        }
    }

    HomePageLayout(
        viewState = viewState,
        onButtonClick = { viewModel.handleIntent(HomePageIntent.NavigateToProfile) }
    )*/
}