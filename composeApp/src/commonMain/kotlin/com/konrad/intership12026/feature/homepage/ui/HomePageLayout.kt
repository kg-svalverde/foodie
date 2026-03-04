package com.konrad.intership12026.feature.homepage.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.components.cards.AppCalorieKPICard
import com.konrad.intership12026.components.cards.AppMacrosKPICard
import com.konrad.intership12026.components.cards.MacroData
import com.konrad.intership12026.components.carrousel.AppCardCarrousel
import com.konrad.intership12026.components.carrousel.Recipe
import com.konrad.intership12026.feature.homepage.model.HomePageState
import com.konrad.intership12026.ui.theme.AppTheme
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.chicken_alfredo
import intership12026.composeapp.generated.resources.icon_carbs
import intership12026.composeapp.generated.resources.icon_fats
import intership12026.composeapp.generated.resources.icon_proteins
import intership12026.composeapp.generated.resources.pancakes
import intership12026.composeapp.generated.resources.steak_and_veggies
import intership12026.composeapp.generated.resources.yogurt_parfait

@Composable
fun HomePageLayout(
    viewState: HomePageState,
    onRecipeClick: (Recipe) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            // text = "Welcome back,${user.name}",
            text = "Welcome back, Samuel!",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = AppTheme.colors.black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 48.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Remember to track your daily nutrition and stay healthy!",
            style = MaterialTheme.typography.bodyMedium,
            color = AppTheme.colors.black,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        AppCalorieKPICard(
            title = "Daily Progress",
            subtitle = "Calories consumed",
            value = "1524",
            goal = "2100",
            unit = "kcal",
            color = AppTheme.colors.white,
        )
        Spacer(modifier = Modifier.height(16.dp))
        AppMacrosKPICard(
            title = "Daily Macros (P/C/F)",
            subtitle = "Nutrient distribution",
            containerColor = AppTheme.colors.white,
            macros = listOf(
                MacroData(
                    label = "Protein",
                    icon = Res.drawable.icon_proteins,
                    color = AppTheme.colors.primary.copy(1f),
                    current = 150,
                    goal = 200
                ),
                MacroData(
                    label = "Carbs",
                    icon = Res.drawable.icon_carbs,
                    color = AppTheme.colors.secondary,
                    current = 300,
                    goal = 400
                ),
                MacroData(
                    label = "Fats",
                    icon = Res.drawable.icon_fats,
                    color = AppTheme.colors.tertiary.copy(1f),
                    current = 60,
                    goal = 100
                )
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Today's meal suggestions",
            style = MaterialTheme.typography.labelLarge,
            color = AppTheme.colors.black,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        AppCardCarrousel(
            recipes = viewState.recipes,
            onRecipeClick = onRecipeClick
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun HomePageLayoutPreview() {
    AppTheme {
        HomePageLayout(
            viewState = HomePageState(
                name = "Samuel",
                recipes = listOf(
                    Recipe("Breakfast", "Pancakes", "530 kcal", Res.drawable.pancakes),
                    Recipe("Lunch", "Chicken Alfredo", "420 kcal", Res.drawable.chicken_alfredo),
                    Recipe("Snack", "Yogurt Parfait", "210 kcal", Res.drawable.yogurt_parfait),
                    Recipe("Dinner", "Steak & Veggies", "550 kcal", Res.drawable.steak_and_veggies)
                )
            )
        )
    }
}
