package com.konrad.intership12026.components.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.ui.theme.AppTheme
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.foodie
import intership12026.composeapp.generated.resources.user1
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHeader(
    onBackClick: (() -> Unit)? = null,
    profileImage: DrawableResource? = null,
    onProfileClick: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    val appColors = AppTheme.colors

    CenterAlignedTopAppBar(
        modifier = Modifier
            .height(60.dp),
        title = {
            Image(
                painter = painterResource(Res.drawable.foodie),
                contentDescription = "App's logo: Foodie",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(80.dp)
                    .padding(12.dp)
            )
        },
        navigationIcon = {
            if (onBackClick != null) {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = appColors.black)
                }
            }
        },
        actions = {
            actions()
            if (profileImage != null) {
                IconButton(onClick = { onProfileClick?.invoke() }) {
                    Image(
                        painter = painterResource(profileImage),
                        contentDescription = "Profile image",
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = appColors.background
        )
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun AppHeaderPreview() {
    AppTheme {
        AppHeader(
            onBackClick = {},
            profileImage = Res.drawable.user1,
            onProfileClick = {}
        )
    }
}
