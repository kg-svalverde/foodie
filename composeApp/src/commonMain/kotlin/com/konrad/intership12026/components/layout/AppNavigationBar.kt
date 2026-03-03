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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.navigation.destination.NavDestination
import com.konrad.intership12026.ui.theme.AppTheme
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.icon_home1
import intership12026.composeapp.generated.resources.icon_marketmap
import intership12026.composeapp.generated.resources.icon_mealplanner
import intership12026.composeapp.generated.resources.icon_profile
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

enum class NavItem(
    val title: String,
    val icon: DrawableResource,
    val destination: NavDestination
) {
    Home("Home", Res.drawable.icon_home1, NavDestination.HomePage),
    MealPlanner("Meal Planner", Res.drawable.icon_mealplanner, NavDestination.MealPlanner),
    MarketMap("Market Map", Res.drawable.icon_marketmap, NavDestination.MarketMap),
    Profile("Profile", Res.drawable.icon_profile, NavDestination.Profile);

    companion object {
        fun fromDestination(destination: NavDestination?): NavItem? {
            return entries.find { it.destination == destination }
        }
    }
}

@Composable
fun AppNavigationBar(
    currentDestination: NavDestination?,
    onItemSelected: (NavDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    val appColors = AppTheme.colors
    val selectedItem = NavItem.fromDestination(currentDestination)

    NavigationBar(
        modifier = modifier,
        containerColor = appColors.background
    ) {
        NavItem.entries.forEach { item ->
            val isSelected = selectedItem == item
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemSelected(item.destination) },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp),
                        tint = if (isSelected) appColors.primary else appColors.gray
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.labelSmall,
                        color = if (isSelected) appColors.primary else appColors.gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = appColors.primary.copy(alpha = 0.1f)
                )
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun AppNavigationBarPreview() {
    AppTheme {
        AppNavigationBar(
            currentDestination = NavDestination.HomePage,
            onItemSelected = {}
        )
    }
}