package com.konrad.intership12026.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konrad.intership12026.ui.theme.AppTheme
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.icon_carbs
import intership12026.composeapp.generated.resources.icon_fats
import intership12026.composeapp.generated.resources.icon_proteins
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

data class MacroData(
    val label: String,
    val icon: DrawableResource,
    val color: Color,
    val current: Int,
    val goal: Int,
    val unit: String = "g"
)

@Composable
fun AppMacrosKPICard(
    title: String,
    subtitle: String = "",
    macros: List<MacroData>,
    modifier: Modifier = Modifier,
    containerColor: Color = AppTheme.colors.background
) {
    Card(
        modifier = modifier
            .wrapContentWidth()
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor.copy(alpha = 0.3f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = CardDefaults.outlinedCardBorder()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                color = AppTheme.colors.black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.labelMedium,
                color = AppTheme.colors.gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                macros.forEach { macro ->
                    AppMacroCard(
                        macro = macro,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun AppMacroCard(
    macro: MacroData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = macro.color.copy(alpha = 0.2f)
        )
    ) {
        Column(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(macro.color.copy(alpha = 0.3f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(macro.icon),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = macro.label,
                style = MaterialTheme.typography.labelSmall,
                fontSize = 10.sp,
                color = AppTheme.colors.gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${macro.current}",
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppTheme.colors.black,
                    maxLines = 1
                )
                Text(
                    text = "/${macro.goal}${macro.unit}",
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 9.sp,
                    color = AppTheme.colors.gray,
                    maxLines = 1,
                    modifier = Modifier.padding(bottom = 1.dp, start = 1.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun AppMacrosKPICardPreview() {
    AppTheme {
        AppMacrosKPICard(
            title = "Daily Macros (P/C/F)",
            subtitle = "Nutrient distribution",
            containerColor = AppTheme.colors.white,
            macros = listOf(
                MacroData(
                    label = "Protein",
                    icon = Res.drawable.icon_proteins,
                    color = Color.Red.copy(0.35f),
                    current = 150,
                    goal = 200
                ),
                MacroData(
                    label = "Carbs",
                    icon = Res.drawable.icon_carbs,
                    color = Color.Green.copy(0.35f),
                    current = 300,
                    goal = 400
                ),
                MacroData(
                    label = "Fats",
                    icon = Res.drawable.icon_fats,
                    color = Color.Yellow.copy(0.35f),
                    current = 60,
                    goal = 100
                )
            )
        )
    }
}
