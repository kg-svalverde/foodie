package com.konrad.intership12026.feature.marketmap.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.konrad.intership12026.feature.marketmap.model.MarketMapEvent
import com.konrad.intership12026.feature.marketmap.model.MarketMapIntent
import com.konrad.intership12026.feature.marketmap.viewmodel.MarketMapViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MarketMapView(
    navBackStack: NavBackStack<NavKey>,
    viewModel: MarketMapViewModel = koinViewModel(),
) {
    /*val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect {
            when (it) {
                is MarketMapEvent.NavigateTo -> navBackStack.add(it.destination)
            }
        }
    }

    MarketMapLayout(
        viewState = viewState,
        onButtonClick = { viewModel.handleIntent(MarketMapIntent.NavigateToProfile) }
    )*/
}