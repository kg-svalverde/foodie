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
            titleLarge = TextStyle(
                fontFamily = font,
                fontWeight = FontWeight.Bold,
                fontSize = 38.sp
            ),
            titleMedium = TextStyle(
                fontFamily = font,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            ),
            titleSmall = TextStyle(
                fontFamily = font,
                fontWeight = FontWeight.Normal,
                fontSize = 28.sp
            ),
            bodyMedium = TextStyle(
                fontFamily = font,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
        )
    }
    content(typography)
}

@Composable
fun getInterFontFamily() = FontFamily(Font(Res.font.Inter_VariableFont))