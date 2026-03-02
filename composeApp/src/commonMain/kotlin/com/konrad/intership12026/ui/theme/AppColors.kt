package com.konrad.intership12026.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Project Color Palette
enum class AppPalette(val color: Color) {
    Primary(Color(0xFF135e4b)),
    Secondary(Color(0xFF4CB572)),
    Tertiary(Color(0xFFA1D8B5)),
    Quaternary(Color(0xFFCCDCDB)),
    Black(Color(0xFF000000)),
    Gray(Color(0xFFB1B1B1)),
    LightGray(Color(0xFFEDEDED)),
    Background(Color(0xFFFFFFFF)),
    Error(Color(0xFFB00020))
}

data class AppColors(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val quaternary: Color,
    val black: Color,
    val gray: Color,
    val lightGray: Color,
    val background: Color,
    val error: Color,
    val isLight: Boolean
)

// Local provider
val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("No AppColors provided.")
}