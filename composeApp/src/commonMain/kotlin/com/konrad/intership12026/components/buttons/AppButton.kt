package com.konrad.intership12026.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.ui.theme.AppTheme

enum class ButtonVariant {
    Primary,
    Secondary,
    Outline
}

@Composable
fun AppButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.Primary,
    isLoading: Boolean = false,
    content: @Composable RowScope.() -> Unit
) {
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

    val appColors = AppTheme.colors
    val buttonColors = when (variant) {
        ButtonVariant.Primary -> ButtonDefaults.buttonColors(
            containerColor = appColors.primary,
            contentColor = appColors.background
        )
        ButtonVariant.Secondary -> ButtonDefaults.buttonColors(
            containerColor = appColors.secondary,
            contentColor = appColors.background
        )
        ButtonVariant.Outline -> ButtonDefaults.outlinedButtonColors(
            contentColor = appColors.primary
        )
    }

    Button(
        onClick = onClick,
        modifier = modifier.heightIn(min = 48.dp),
        enabled = enabled,
        colors = buttonColors,
        shape = RoundedCornerShape(12.dp),
        border = if (variant == ButtonVariant.Outline)
            BorderStroke(1.dp, appColors.primary) else null,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                color = if (variant == ButtonVariant.Outline) appColors.primary else appColors.background,
                strokeWidth = 2.dp
            )
        } else {
            content()
        }
    }
}

/*
AppButton(
onClick = { },
variant = ButtonVariant.Outline,
modifier = Modifier.padding(16.dp)
) {
    Icon(Icons.Default.Add, contentDescription = null)
    Spacer(Modifier.width(8.dp))
    Text("Create New KPI", style = MaterialTheme.typography.titleSmall)
}*/
