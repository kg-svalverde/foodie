package com.konrad.intership12026.feature.mealplanner.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konrad.intership12026.data.AppData
import com.konrad.intership12026.data.DailyPlan
import com.konrad.intership12026.data.WeeklyPlan
import com.konrad.intership12026.feature.mealplanner.model.MealPlannerEvent
import com.konrad.intership12026.feature.mealplanner.model.MealPlannerIntent
import com.konrad.intership12026.feature.mealplanner.model.MealPlannerState
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
class MealPlannerViewModel() : ViewModel() {
    private val _viewState = MutableStateFlow(
        MealPlannerState()
    )
    val viewState = _viewState.asStateFlow()

    private val _event = Channel<MealPlannerEvent>()
    val event = _event.receiveAsFlow()

    init {
        observeData()
        generateInitialWeeklyPlan()
    }

    private fun observeData() {
        AppData.currentUser.onEach { user ->
            _viewState.update { it.copy(user = user) }
        }.launchIn(viewModelScope)
    }

    private fun generateInitialWeeklyPlan() {
        val days = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val categories = listOf("Breakfast", "Snack", "Lunch", "Dinner")
        
        val plans = days.map { day ->
            val dailyMeals = categories.mapNotNull { category ->
                AppData.recipes
                    .filter { it.category == category }
                    .shuffled()
                    .firstOrNull()
            }
            DailyPlan(
                dayName = day,
                meals = dailyMeals
            )
        }
        _viewState.update { it.copy(weeklyPlan = WeeklyPlan(plans)) }
    }

    fun handleIntent(intent: MealPlannerIntent) {
        when (intent) {
            is MealPlannerIntent.DaySelected -> {
                _viewState.update { it.copy(selectedDayIndex = intent.index) }
            }
            is MealPlannerIntent.RecipeClicked -> {
                _viewState.update { it.copy(selectedRecipe = intent.recipe) }
            }
            is MealPlannerIntent.DismissRecipeDialog -> {
                _viewState.update { it.copy(selectedRecipe = null) }
            }
        }
    }

    private fun emitNavigationEvent(destination: NavDestination) {
        viewModelScope.launch {
            _event.send(MealPlannerEvent.NavigateTo(destination))
        }
    }
}
