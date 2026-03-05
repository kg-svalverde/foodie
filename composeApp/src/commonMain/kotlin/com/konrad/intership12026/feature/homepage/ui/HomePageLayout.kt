package com.konrad.intership12026.feature.homepage.ui

import androidx.compose.foundation.background
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
import com.konrad.intership12026.data.RecipeModel
import com.konrad.intership12026.data.UserAttributes
import com.konrad.intership12026.data.UserModel
import com.konrad.intership12026.feature.homepage.model.HomePageState
import com.konrad.intership12026.ui.theme.AppTheme
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.chicken_alfredo
import intership12026.composeapp.generated.resources.icon_carbs
import intership12026.composeapp.generated.resources.icon_fats
import intership12026.composeapp.generated.resources.icon_proteins
import intership12026.composeapp.generated.resources.steak_and_veggies
import intership12026.composeapp.generated.resources.user1
import intership12026.composeapp.generated.resources.yogurt_parfait


@Composable
fun HomePageLayout(
    viewState: HomePageState,
    onRecipeClick: (RecipeModel) -> Unit = {},
) {
    val user = viewState.user

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
            .padding(horizontal = 32.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .padding(top = 32.dp)
        ) {
            Text(
                text = user?.let { "Welcome back, ${it.firstName}!" } ?: "Welcome!",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = AppTheme.colors.black
            )
            Text(
                text = "Remember: Healthy eating, healthy living!",
                style = MaterialTheme.typography.bodyMedium,
                color = AppTheme.colors.gray
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
        ) {
            user?.let {
                AppCalorieKPICard(
                    title = "Daily Progress",
                    subtitle = "Calories consumed",
                    value = it.attributes.consumedCalories.toString(),
                    goal = it.attributes.dailyCalories.toString(),
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
                            current = it.attributes.consumedProtein,
                            goal = it.attributes.proteinGrams
                        ),
                        MacroData(
                            label = "Carbs",
                            icon = Res.drawable.icon_carbs,
                            color = AppTheme.colors.secondary,
                            current = it.attributes.consumedCarbs,
                            goal = it.attributes.carbGrams
                        ),
                        MacroData(
                            label = "Fats",
                            icon = Res.drawable.icon_fats,
                            color = AppTheme.colors.tertiary.copy(1f),
                            current = it.attributes.consumedFats,
                            goal = it.attributes.fatGrams
                        )
                    )
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Today's meal suggestions",
                style = MaterialTheme.typography.labelLarge,
                color = AppTheme.colors.black,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

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
                user = UserModel(
                    email = "user1@gmail.com",
                    password = "1234",
                    firstName = "Alex",
                    lastName = "Collins",
                    profilePic = Res.drawable.user1,
                    allergies = mutableListOf("Peanuts", "Seafood"),
                    restrictions = mutableListOf("Dairy-free"),
                    attributes = UserAttributes(
                        age = 28,
                        height = 180,
                        weight = 75f,
                        activityLevel = "Active",
                        healthGoal = "Maintain Weight",
                        dailyCalories = 2400,
                        proteinGrams = 130,
                        carbGrams = 300,
                        fatGrams = 60,
                        consumedCalories = 1524,
                        consumedProtein = 90,
                        consumedCarbs = 210,
                        consumedFats = 45
                    )
                ),
                recipes = listOf(
                    RecipeModel(
                        category = "Dinner",
                        title = "Vegetarian Lasagna",
                        image = Res.drawable.chicken_alfredo,
                        description = "Cheesy eggplant lasagna",
                        ingredients = listOf("Eggplant", "Cheese", "Tomato sauce"),
                        steps = listOf("Layer ingredients", "Bake till golden"),
                        macros = listOf(22, 40, 20),
                        calories = "440 kcal"
                    ),
                    RecipeModel(
                        category = "Snack",
                        title = "Mixed Nuts",
                        image = Res.drawable.yogurt_parfait,
                        description = "Handful of roasted nuts",
                        ingredients = listOf("Almonds", "Walnuts", "Cashews"),
                        steps = listOf("Roast nuts", "Enjoy"),
                        macros = listOf(6, 5, 18),
                        calories = "180 kcal"
                    ),
                    RecipeModel(
                        category = "Dinner",
                        title = "Pork Tenderloin",
                        image = Res.drawable.steak_and_veggies,
                        description = "Roasted pork with herbs",
                        ingredients = listOf("Pork", "Rosemary", "Potatoes"),
                        steps = listOf("Sear meat", "Bake in oven"),
                        macros = listOf(38, 30, 14),
                        calories = "410 kcal"
                    )
                )
            )
        )
    }
}
