package com.konrad.intership12026.feature.mealplanner.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.konrad.intership12026.feature.mealplanner.model.MealPlannerIntent
import com.konrad.intership12026.feature.mealplanner.model.MealPlannerEvent
import com.konrad.intership12026.feature.mealplanner.viewmodel.MealPlannerViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MealPlannerView(
    navBackStack: NavBackStack<NavKey>,
    viewModel: MealPlannerViewModel = koinViewModel(),
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect {
            when (it) {
                is MealPlannerEvent.NavigateTo -> navBackStack.add(it.destination)
            }
        }
    }

    MealPlannerLayout(
        viewState = viewState,
        onDaySelected = { viewModel.handleIntent(MealPlannerIntent.DaySelected(it)) },
        onRecipeClick = { viewModel.handleIntent(MealPlannerIntent.RecipeClicked(it)) },
        onDismissDialog = { viewModel.handleIntent(MealPlannerIntent.DismissRecipeDialog) }
    )
}
