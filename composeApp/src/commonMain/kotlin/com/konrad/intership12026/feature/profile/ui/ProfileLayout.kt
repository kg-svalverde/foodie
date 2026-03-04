package com.konrad.intership12026.feature.profile.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults.buttonColors
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
import com.konrad.intership12026.feature.profile.model.ProfileState
import com.konrad.intership12026.ui.theme.AppTheme
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.icon_carbs
import intership12026.composeapp.generated.resources.icon_fats
import intership12026.composeapp.generated.resources.icon_proteins

@Composable
fun ProfileLayout(
    viewState: ProfileState,
    onEditProfileClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Your profile",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = AppTheme.colors.black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 48.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Manage your account and personal information.",
            style = MaterialTheme.typography.bodyMedium,
            color = AppTheme.colors.black,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        
        AppProfileInfoCard(
            title = "Personal Information",
            subtitle = "Your physical data and goals",
            color = AppTheme.colors.white,
            infoItems = listOf(
                ProfileInfoItem("Age", "${viewState.age} years"),
                ProfileInfoItem("Weight", viewState.weight),
                ProfileInfoItem("Height", viewState.height),
                ProfileInfoItem("Primary Goal", viewState.goal),
                ProfileInfoItem("Allergies", viewState.allergies),
                ProfileInfoItem("Restrictions", viewState.restrictions)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            onClick = onEditProfileClick,
            variant = ButtonVariant.Base
        ) {
            Text(text = "Continue")
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
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
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun ProfileLayoutPreview() {
    AppTheme {
        ProfileLayout(
            viewState = ProfileState()
        )
    }
}
