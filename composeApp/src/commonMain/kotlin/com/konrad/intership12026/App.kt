package com.konrad.intership12026

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.konrad.intership12026.navigation.MainNavHost

@Composable
@Preview
fun App() {
    MaterialTheme {
        MainNavHost()
    }
}