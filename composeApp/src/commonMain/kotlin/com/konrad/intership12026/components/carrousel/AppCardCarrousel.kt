package com.konrad.intership12026.components.carrousel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.components.cards.AppRecipeCard
import com.konrad.intership12026.ui.theme.AppTheme
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.chicken_alfredo
import org.jetbrains.compose.resources.DrawableResource

data class Recipe(
    val category: String,
    val title: String,
    val calories: String,
    val image: DrawableResource
)

@Composable
fun AppCardCarrousel(
    recipes: List<Recipe>,
    onRecipeClick: (Recipe) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(recipes) { recipe ->
            AppRecipeCard(
                category = recipe.category,
                title = recipe.title,
                calories = recipe.calories,
                image = recipe.image,
                onClick = { onRecipeClick(recipe) }
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun AppCardCarrouselPreview() {
    AppTheme {
        AppCardCarrousel(
            recipes = listOf(
                Recipe("Breakfast", "Pancakes", "530 kcal", Res.drawable.chicken_alfredo),
                Recipe("Lunch", "Chicken Alfredo", "420 kcal", Res.drawable.chicken_alfredo),
                Recipe("Dinner", "Steak & Veggies", "550 kcal", Res.drawable.chicken_alfredo),
                Recipe("Snack", "Yogurt Parfait", "210 kcal", Res.drawable.chicken_alfredo)
            ),
            onRecipeClick = {}
        )
    }
}
