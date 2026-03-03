package com.konrad.intership12026.components.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.feature.login.model.LoginState
import com.konrad.intership12026.feature.login.ui.LoginLayout
import com.konrad.intership12026.ui.theme.AppTheme
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.foodie
import org.jetbrains.compose.resources.painterResource

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
            Image(
                painter = painterResource(Res.drawable.foodie),
                contentDescription = "App's logo: Foodie",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(80.dp)
                    .padding(bottom = 32.dp)
            )
            /*Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = appColors.black
            )*/
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

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun LoginLayoutPreview() {
    AppTheme {
        AppHeader(
            title = "Foodie",
            onBackClick = {}
        )
    }
}