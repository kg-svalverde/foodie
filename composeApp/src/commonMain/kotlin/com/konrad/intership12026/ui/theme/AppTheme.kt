package com.konrad.intership12026.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.konrad.intership12026.ui.ProvideAppTypography

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        AppColors(
            primary = Color(0xFF81C784),
            secondary = Color(0xFF4CB572),
            tertiary = Color(0xFF2E4D3E),
            quaternary = Color(0xFF1E2E28),
            black = Color(0xFFFFFFFF),
            gray = Color(0xFF888888),
            lightGray = Color(0xFF2C2C2C),
            background = Color(0xFF121212),
            error = Color(0xFFCF6679),
            isLight = false
        )
    } else {
        AppColors(
            primary = AppPalette.Primary.color,
            secondary = AppPalette.Secondary.color,
            tertiary = AppPalette.Tertiary.color,
            quaternary = AppPalette.Quaternary.color,
            black = AppPalette.Black.color,
            gray = AppPalette.Gray.color,
            lightGray = AppPalette.LightGray.color,
            background = AppPalette.Background.color,
            error = AppPalette.Error.color,
            isLight = true
        )
    }

    CompositionLocalProvider(LocalAppColors provides colors) {
        ProvideAppTypography {
            typography -> MaterialTheme(
                typography = typography,
                content = content
            )
        }
    }
}

object AppTheme {
    val colors: AppColors
        @Composable
        get() = LocalAppColors.current
}