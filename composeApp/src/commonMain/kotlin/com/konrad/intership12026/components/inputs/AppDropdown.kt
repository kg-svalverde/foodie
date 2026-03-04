package com.konrad.intership12026.components.inputs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.ui.theme.AppTheme
import kotlin.String

@Composable
fun AppDropdown(
    options: List<String>,
    selectedOption: String? = null,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    style: TextStyle,
    placeholder: String = "",
) {
    var expanded by remember { mutableStateOf(false) }
    val appColors = AppTheme.colors

    Column(modifier = modifier) {
        label?.let {
            Text(
                text = it,
                style = style,
                color = appColors.black,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
        }
        Column {
            OutlinedTextField(
                value = "",
                onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                readOnly = true,
                placeholder = {
                    Text(
                        text = placeholder,
                        color = appColors.gray,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier.clickable { expanded = !expanded }
                    )
                },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = appColors.primary,
                    unfocusedBorderColor = appColors.lightGray,
                    focusedContainerColor = appColors.background,
                    unfocusedContainerColor = appColors.background,
                    cursorColor = appColors.primary
                )
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth(0.85f) // Adjust width as needed
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(text = option) },
                        onClick = {
                            onOptionSelected(option)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun AppDropdownPreview() {
    AppTheme {
        AppDropdown(
            options = listOf("vegetarian", "vegan", "gluten-free", "dairy-free"),
            onOptionSelected = { },
            modifier = Modifier,
            label = "Dietary preferences",
            style = MaterialTheme.typography.titleMedium,
            placeholder = "Select an option",
        )
    }
}
