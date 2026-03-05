package com.konrad.intership12026.feature.profile.ui

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
import com.konrad.intership12026.components.buttons.AppButton
import com.konrad.intership12026.components.buttons.ButtonVariant
import com.konrad.intership12026.components.cards.AppCalorieKPICard
import com.konrad.intership12026.components.cards.AppMacrosKPICard
import com.konrad.intership12026.components.cards.AppProfileInfoCard
import com.konrad.intership12026.components.cards.MacroData
import com.konrad.intership12026.components.cards.ProfileInfoItem
import com.konrad.intership12026.data.UserAttributes
import com.konrad.intership12026.data.UserModel
import com.konrad.intership12026.feature.profile.model.ProfileState
import com.konrad.intership12026.ui.theme.AppTheme
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.icon_carbs
import intership12026.composeapp.generated.resources.icon_fats
import intership12026.composeapp.generated.resources.icon_proteins
import intership12026.composeapp.generated.resources.user1

@Composable
fun ProfileLayout(
    viewState: ProfileState,
    onEditProfileClick: () -> Unit = {}
) {
    val user = viewState.user

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .padding(top = 32.dp)
        ) {
            Text(
                text = "Your Profile",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = AppTheme.colors.black
            )
            Text(
                text = "Manage your account and personal information.",
                style = MaterialTheme.typography.bodyMedium,
                color = AppTheme.colors.gray
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        
        user?.let {
            AppProfileInfoCard(
                title = "Personal Information",
                subtitle = "Your physical data and goals",
                color = AppTheme.colors.white,
                infoItems = listOf(
                    ProfileInfoItem("Age", "${it.attributes.age} years"),
                    ProfileInfoItem("Weight", "${it.attributes.weight} kg"),
                    ProfileInfoItem("Height", "${it.attributes.height} cm"),
                    ProfileInfoItem("Primary Goal", it.attributes.healthGoal),
                    ProfileInfoItem("Allergies", it.allergies.joinToString(", ").ifEmpty { "None" }),
                    ProfileInfoItem("Restrictions", it.restrictions.joinToString(", ").ifEmpty { "None" })
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(
            onClick = onEditProfileClick,
            modifier = Modifier.fillMaxWidth(),
            variant = ButtonVariant.Outline
        ) {
            Text(
                text = "Edit Personal Information",
                style = MaterialTheme.typography.titleSmall,
                color = AppTheme.colors.primary
            )
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
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
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun ProfileLayoutPreview() {
    AppTheme {
        ProfileLayout(
            viewState = ProfileState(
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
                )
            )
        )
    }
}
