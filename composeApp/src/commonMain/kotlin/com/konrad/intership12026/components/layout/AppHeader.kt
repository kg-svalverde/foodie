package com.konrad.intership12026.components.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
        modifier = Modifier,
        title = {
            Image(
                painter = painterResource(Res.drawable.foodie),
                contentDescription = "Foodie Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(32.dp)
                    .padding(horizontal = 8.dp)
            )
        },
        navigationIcon = {
            if (onBackClick != null) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = appColors.black
                    )
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
                            .size(32.dp) // Standard icon button size is usually 48dp, image 32dp
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = appColors.background,
            titleContentColor = appColors.black
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
