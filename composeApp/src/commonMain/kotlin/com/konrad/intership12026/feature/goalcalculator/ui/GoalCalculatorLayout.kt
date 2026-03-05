package com.konrad.intership12026.feature.goalcalculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.components.buttons.AppButton
import com.konrad.intership12026.components.buttons.ButtonVariant
import com.konrad.intership12026.components.inputs.AppDropdown
import com.konrad.intership12026.components.inputs.AppTextField
import com.konrad.intership12026.components.cards.AppCalcCard
import com.konrad.intership12026.feature.goalcalculator.model.GoalCalculatorState
import com.konrad.intership12026.ui.theme.AppTheme

@Composable
fun GoalCalculatorLayout(
    viewState: GoalCalculatorState,
    onAgeChange: (Float) -> Unit = {},
    onHeightChange: (String) -> Unit = {},
    onWeightChange: (String) -> Unit = {},
    onActivityLevelChange: (String) -> Unit = {},
    onHealthGoalChange: (String) -> Unit = {},
    onButtonClick: () -> Unit = {},
) {
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
                text = "Goal Calculator",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = AppTheme.colors.black
            )
            Text(
                text = "Everything we need to know!",
                style = MaterialTheme.typography.bodyMedium,
                color = AppTheme.colors.gray
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AppCalcCard(
                title = "Daily Calories",
                value = "${viewState.dailyCalories}",
                unit = "kcal",
                color = AppTheme.colors.quaternary,
                type = "calories",
                modifier = Modifier.fillMaxHeight()
            )
            AppCalcCard(
                title = "Macros (P/C/F)",
                value = "${viewState.proteinGrams}/${viewState.carbGrams}/${viewState.fatGrams}",
                unit = "grams",
                modifier = Modifier.weight(1f).fillMaxHeight(),
                color = AppTheme.colors.quaternary,
                type = "macros"
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Column(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Age",
                        style = MaterialTheme.typography.titleSmall,
                        color = AppTheme.colors.black
                    )
                    Text(
                        text = "${viewState.age.toInt()} years",
                        style = MaterialTheme.typography.bodyMedium,
                        color = AppTheme.colors.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
                Slider(
                    value = viewState.age,
                    onValueChange = onAgeChange,
                    valueRange = 15f..100f,
                    colors = SliderDefaults.colors(
                        thumbColor = AppTheme.colors.secondary,
                        activeTrackColor = AppTheme.colors.secondary,
                        inactiveTrackColor = AppTheme.colors.lightGray
                    )
                )
            }

            AppTextField(
                value = viewState.height.toString(),
                label = "Height (cm)",
                onValueChange = onHeightChange,
                placeholder = "e.g. 175",
                style = MaterialTheme.typography.titleSmall,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            AppTextField(
                value = viewState.weight.toString(),
                label = "Weight (kg)",
                onValueChange = onWeightChange,
                placeholder = "e.g. 70",
                style = MaterialTheme.typography.titleSmall,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            AppDropdown(
                options = listOf("Sedentary", "Moderately Active", "Active", "Very Active"),
                selectedOption = viewState.activityLevel,
                onOptionSelected = onActivityLevelChange,
                label = "Activity Level",
                placeholder = "Select activity level",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            AppDropdown(
                options = listOf("Lose Weight", "Maintain Weight", "Gain Weight"),
                selectedOption = viewState.healthGoal,
                onOptionSelected = onHealthGoalChange,
                label = "Primary health goal",
                placeholder = "Select health goal",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )

            AppButton(
                modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),
                onClick = onButtonClick,
                variant = ButtonVariant.Base
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun GoalCalculatorLayoutPreview() {
    AppTheme {
        GoalCalculatorLayout(
            viewState = GoalCalculatorState(
                age = 28f,
                height = 180,
                weight = 75f,
                activityLevel = "Active",
                healthGoal = "Maintain Weight",
                dailyCalories = 2400,
                proteinGrams = 150,
                carbGrams = 300,
                fatGrams = 60
            )
        )
    }
}
