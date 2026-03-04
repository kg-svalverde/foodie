package com.konrad.intership12026.feature.goalcalculator.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.konrad.intership12026.feature.goalcalculator.model.GoalCalculatorEvent
import com.konrad.intership12026.feature.goalcalculator.model.GoalCalculatorIntent
import com.konrad.intership12026.feature.goalcalculator.viewmodel.GoalCalculatorViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GoalCalculatorView(
    navBackStack: NavBackStack<NavKey>,
    viewModel: GoalCalculatorViewModel = koinViewModel(),
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect {
            when (it) {
                is GoalCalculatorEvent.NavigateTo -> navBackStack.add(it.destination)
            }
        }
    }

    GoalCalculatorLayout(
        viewState = viewState,
        onButtonClick = { viewModel.handleIntent(GoalCalculatorIntent.NavigateToHomePage) }
    )
}