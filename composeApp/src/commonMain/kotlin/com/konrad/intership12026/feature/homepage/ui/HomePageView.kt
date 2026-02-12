package com.konrad.intership12026.feature.homepage.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.konrad.intership12026.feature.homepage.viewmodel.HomePageViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomePageView(viewModel: HomePageViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HomePageLayout(state)
}