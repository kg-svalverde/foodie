package com.konrad.intership12026.feature.initialsetup.ui

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.components.buttons.AppButton
import com.konrad.intership12026.components.buttons.ButtonVariant
import com.konrad.intership12026.components.inputs.AppDropdown
import com.konrad.intership12026.components.inputs.AppMultiSelectDropdown
import com.konrad.intership12026.components.inputs.AppTextField
import com.konrad.intership12026.feature.initialsetup.model.InitialSetupState
import com.konrad.intership12026.ui.theme.AppTheme

@Composable
fun InitialSetupLayout(
    viewState: InitialSetupState,
    onNameChange: (String) -> Unit = {},
    onDietaryPreferenceChange: (String) -> Unit = {},
    onAllergySelected: (String) -> Unit = {},
    onAllergyRemoved: (String) -> Unit = {},
    onButtonClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Initial Setup",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = AppTheme.colors.black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp, top = 16.dp)
        )
        
        AppTextField(
            value = viewState.name,
            label = "Name",
            onValueChange = onNameChange,
            placeholder = "Enter your name",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        AppDropdown(
            options = listOf("vegetarian", "vegan", "gluten-free", "dairy-free"),
            selectedOption = viewState.dietaryPreference,
            onOptionSelected = onDietaryPreferenceChange,
            label = "Dietary preferences",
            placeholder = "Select your preference",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        AppMultiSelectDropdown(
            options = listOf("dairy", "seafood", "spices", "eggs", "wheat", "peanuts"),
            selectedOptions = viewState.allergies,
            onOptionSelected = onAllergySelected,
            onOptionRemoved = onAllergyRemoved,
            label = "Allergies and restrictions",
            placeholder = "Select allergies",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        AppButton(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            onClick = onButtonClick,
            variant = ButtonVariant.Base
        ) {
            Text(text = "Continue")
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun InitialSetupLayoutPreview() {
    AppTheme {
        InitialSetupLayout(
            viewState = InitialSetupState(
                name = "John Doe",
                dietaryPreference = "vegan",
                allergies = listOf("peanuts", "seafood")
            )
        )
    }
}
