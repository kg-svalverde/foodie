package com.konrad.intership12026.feature.mealplanner.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.konrad.intership12026.components.cards.AppRecipeCard
import com.konrad.intership12026.data.DailyPlan
import com.konrad.intership12026.data.RecipeModel
import com.konrad.intership12026.data.UserAttributes
import com.konrad.intership12026.data.UserModel
import com.konrad.intership12026.data.WeeklyPlan
import com.konrad.intership12026.feature.mealplanner.model.MealPlannerState
import com.konrad.intership12026.ui.theme.AppTheme
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.chicken_alfredo
import intership12026.composeapp.generated.resources.user1
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealPlannerLayout(
    viewState: MealPlannerState,
    onDaySelected: (Int) -> Unit = {},
    onRecipeClick: (RecipeModel) -> Unit = {},
    onDismissDialog: () -> Unit = {}
) {
    val days = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(AppTheme.colors.background)
                .padding(horizontal = 32.dp)
        ) {
            // Header
            Column(
                modifier = Modifier

                    .padding(top = 32.dp)
            ) {
                Text(
                    text = "Meal Planner",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = AppTheme.colors.black
                )
                Text(
                    text = "Organize and customize your weekly plan!",
                    style = MaterialTheme.typography.bodyMedium,
                    color = AppTheme.colors.gray
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(days.size) { index ->
                    val isSelected = index == viewState.selectedDayIndex
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(if (isSelected) AppTheme.colors.primary else AppTheme.colors.white)
                            .clickable { onDaySelected(index) }
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = days[index],
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            color = if (isSelected) AppTheme.colors.white else AppTheme.colors.black
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            val currentDayPlan = viewState.weeklyPlan?.plans?.getOrNull(viewState.selectedDayIndex)
            val categories = listOf("Breakfast", "Snack", "Lunch", "Dinner")

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 32.dp)
            ) {
                categories.forEach { category ->
                    val categoryRecipes = currentDayPlan?.meals?.filter { it.category == category } ?: emptyList()

                    if (categoryRecipes.isNotEmpty()) {
                        item {
                            Text(
                                text = category,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = AppTheme.colors.black,
                                modifier = Modifier
                                    .padding(horizontal = 32.dp, vertical = 16.dp)
                            )
                        }

                        items(categoryRecipes) { recipe ->
                            AppRecipeCard(
                                onClick = { onRecipeClick(recipe) },
                                category = recipe.category,
                                title = recipe.title,
                                calories = recipe.calories,
                                image = recipe.image,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 32.dp, vertical = 8.dp)
                                    .width(Double.NaN.dp)
                            )
                        }
                    }
                }
            }
        }
        if (viewState.selectedRecipe != null) {
            RecipeDetailDialog(
                recipe = viewState.selectedRecipe,
                onDismiss = onDismissDialog
            )
        }
    }
}

@Composable
fun RecipeDetailDialog(
    recipe: RecipeModel,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(16.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = AppTheme.colors.white)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(24.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    Image(
                        painter = painterResource(recipe.image),
                        contentDescription = recipe.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = recipe.category,
                    style = MaterialTheme.typography.labelLarge,
                    color = AppTheme.colors.primary
                )
                Text(
                    text = recipe.title,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = AppTheme.colors.black
                )
                Text(
                    text = recipe.calories,
                    style = MaterialTheme.typography.bodyLarge,
                    color = AppTheme.colors.gray
                )

                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Description",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = AppTheme.colors.black
                )
                Text(
                    text = recipe.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = AppTheme.colors.black
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Ingredients",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = AppTheme.colors.black
                )
                recipe.ingredients.forEach { ingredient ->
                    Text(
                        text = "• $ingredient",
                        style = MaterialTheme.typography.bodyMedium,
                        color = AppTheme.colors.black
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Steps",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = AppTheme.colors.black
                )
                recipe.steps.forEachIndexed { index, step ->
                    Text(
                        text = "${index + 1}. $step",
                        style = MaterialTheme.typography.bodyMedium,
                        color = AppTheme.colors.black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun MealPlannerLayoutPreview(){
    AppTheme{
        MealPlannerLayout(
            viewState = MealPlannerState(
                user = UserModel(
                    email = "user1@gmail.com", password = "1234", firstName = "Alex", lastName = "Collins",
                    profilePic = Res.drawable.user1, allergies = mutableListOf<String>("Peanuts","Seafood","Wheat"),
                    restrictions = mutableListOf<String>("Vegan","Dairy-free"), attributes = UserAttributes
                    (
                        age = 28, height = 180, weight = 75f, activityLevel = "Active", healthGoal = "Maintain Weight",
                        dailyCalories = 2400, proteinGrams = 130, carbGrams = 300, fatGrams = 60,
                        consumedCalories = 2100, consumedProtein = 120, consumedCarbs = 280, consumedFats = 70
                    )
                ),
                weeklyPlan = WeeklyPlan(
                    plans = listOf(
                        /*DailyPlan(
                            meals = listOf(

                        )*/
                    )
                ),
                selectedDayIndex = 0,
                selectedRecipe = null
            ),
            onDaySelected = {},
            onRecipeClick = {},
            onDismissDialog = {}
        )
    }
}