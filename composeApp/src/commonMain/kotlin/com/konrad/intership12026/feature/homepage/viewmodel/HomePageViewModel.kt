package com.konrad.intership12026.feature.homepage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konrad.intership12026.feature.homepage.state.HomePageState
import com.konrad.intership12026.usecase.SampleUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class HomePageViewModel(private val useCase: SampleUseCase): ViewModel() {
    private val _state = MutableStateFlow(HomePageState())
    val state = _state.asStateFlow()

    init {
        fetchSample()
    }

    private fun fetchSample() {
        viewModelScope.launch {
            useCase.fetchSample()
                .onSuccess { data ->
                    _state.update { it.copy(information = data) }
                }
                .onFailure {
                    println("Error $it")
                }
        }
    }
}