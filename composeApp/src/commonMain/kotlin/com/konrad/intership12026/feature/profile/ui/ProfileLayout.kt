package com.konrad.intership12026.feature.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileLayout() {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Profile Screen",
        )
    }
}

@Preview
@Composable
private fun ProfileLayoutPreview() {
    ProfileLayout()
}