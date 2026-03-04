package com.konrad.intership12026.ui

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import intership12026.composeapp.generated.resources.Inter_VariableFont
import intership12026.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun ProvideAppTypography(content: @Composable (Typography) -> Unit) {
    val font = getInterFontFamily()
    val typography = remember(font) {
        Typography(
            headlineLarge = TextStyle(
                fontFamily = font,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            ),
            headlineMedium = TextStyle(
                fontFamily = font,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            ),
            titleLarge = TextStyle(
                fontFamily = font,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            ),
            titleMedium = TextStyle(
                fontFamily = font,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            ),
            titleSmall = TextStyle(
                fontFamily = font,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ),
            bodyLarge = TextStyle(
                fontFamily = font,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            ),
            bodyMedium = TextStyle(
                fontFamily = font,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ),
            bodySmall = TextStyle(
                fontFamily = font,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
        )
    }
    content(typography)
}

@Composable
fun getInterFontFamily() = FontFamily(Font(Res.font.Inter_VariableFont))