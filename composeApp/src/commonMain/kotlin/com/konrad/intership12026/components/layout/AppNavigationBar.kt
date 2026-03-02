package com.konrad.intership12026.components.layout

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.ui.theme.AppTheme
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.icon_home1
import intership12026.composeapp.generated.resources.icon_marketmap
import intership12026.composeapp.generated.resources.icon_mealplanner
import intership12026.composeapp.generated.resources.icon_profile
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

enum class NavItem(val title: String, val icon: DrawableResource) {
    Home("Home", Res.drawable.icon_home1),
    MealPlanner("Meal Planner", Res.drawable.icon_mealplanner),
    MarketMap("Market Map", Res.drawable.icon_marketmap),
    Profile("Profile", Res.drawable.icon_profile)
}

@Composable
fun AppNavigationBar(
    selectedItem: NavItem,
    onItemSelected: (NavItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val appColors = AppTheme.colors

    NavigationBar(
        modifier = modifier,
        containerColor = appColors.background
    ) {
        NavItem.entries.forEach { item ->
            NavigationBarItem(
                selected = selectedItem == item,
                onClick = { onItemSelected(item) },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp),
                        tint = if (selectedItem == item) appColors.primary else appColors.gray
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.labelSmall,
                        color = if (selectedItem == item) appColors.primary else appColors.gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = appColors.primary.copy(alpha = 0.1f)
                )
            )
        }
    }
}