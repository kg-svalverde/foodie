package com.konrad.intership12026

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.konrad.intership12026.navigation.MainNavHost
import com.konrad.intership12026.ui.theme.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
        MainNavHost()
    }
}