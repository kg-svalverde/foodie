package com.konrad.intership12026.components.layout

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.konrad.intership12026.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHeader(
    title: String,
    onBackClick: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    val appColors = AppTheme.colors

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = appColors.black
            )
        },
        navigationIcon = {
            if (onBackClick != null) {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = appColors.black)
                }
            }
        },
        actions = actions, // Slot for profile pic or settings icon on the right
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = appColors.background
        )
    )
}