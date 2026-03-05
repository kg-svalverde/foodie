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
import com.konrad.intership12026.data.AppData
import com.konrad.intership12026.data.RecipeModel
import com.konrad.intership12026.ui.theme.AppTheme

@Composable
fun AppCardCarrousel(
    recipes: List<RecipeModel>,
    onRecipeClick: (RecipeModel) -> Unit,
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
            AppData.recipes,
            onRecipeClick = { recipe ->
                println("Recipe clicked: ${recipe.title}")
            }
        )
    }
}
