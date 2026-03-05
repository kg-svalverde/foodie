package com.konrad.intership12026.feature.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.konrad.intership12026.data.AppData
import com.konrad.intership12026.feature.login.model.LoginEvent
import com.konrad.intership12026.feature.login.model.LoginIntent
import com.konrad.intership12026.feature.login.viewmodel.LoginViewModel
import com.konrad.intership12026.navigation.destination.NavDestination
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginView(
    navBackStack: NavBackStack<NavKey>,
    viewModel: LoginViewModel = koinViewModel(),
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is LoginEvent.NavigateTo -> navBackStack.add(event.destination)
            }
        }
    }

    LoginLayout(
        viewState = viewState,
        onEmailChange = { viewModel.handleIntent(LoginIntent.EmailChanged(it)) },
        onPasswordChange = { viewModel.handleIntent(LoginIntent.PasswordChanged(it)) },
        onLoginClick = { viewModel.handleIntent(LoginIntent.LoginClicked) },
        onSignUpClick = { viewModel.handleIntent(LoginIntent.SignUpClicked) }
    )
}