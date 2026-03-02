package com.konrad.intership12026.feature.profile.ui

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.konrad.intership12026.feature.profile.viewmodel.ProfileViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProfileView(
    navBackStack: NavBackStack<NavKey>,
    viewModel: ProfileViewModel = koinViewModel()
) {
    ProfileLayout()
}