package com.konrad.intership12026.components.inputs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.ui.theme.AppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AppMultiSelectDropdown(
    options: List<String>,
    selectedOptions: List<String> = emptyList(),
    onOptionSelected: (String) -> Unit,
    onOptionRemoved: (String) -> Unit,
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
        
        Box {
            OutlinedTextField(
                value = "",
                onValueChange = { },
                modifier = Modifier.fillMaxWidth(),
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
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable { expanded = !expanded }
            )
            
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth(0.85f)
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { 
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Checkbox(
                                    checked = selectedOptions.contains(option),
                                    onCheckedChange = null
                                )
                                Text(text = option, modifier = Modifier.padding(start = 8.dp))
                            }
                        },
                        onClick = {
                            if (selectedOptions.contains(option)) {
                                onOptionRemoved(option)
                            } else {
                                onOptionSelected(option)
                            }
                        }
                    )
                }
            }
        }

        if (selectedOptions.isNotEmpty()) {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                selectedOptions.forEach { option ->
                    AppTag(
                        text = option,
                        onRemove = { onOptionRemoved(option) }
                    )
                }
            }
        }
    }
}

@Composable
fun AppTag(
    text: String,
    onRemove: () -> Unit
) {
    val appColors = AppTheme.colors
    Surface(
        color = appColors.tertiary,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.wrapContentSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                color = appColors.black
            )
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Remove",
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(16.dp)
                    .clickable { onRemove() },
                tint = appColors.black
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun AppMultiSelectDropdownPreview() {
    AppTheme {
        AppMultiSelectDropdown(
            options = listOf("dairy", "seafood", "spices", "eggs", "wheat", "peanuts"),
            modifier = Modifier,
            label = "Allergies and restrictions",
            style = MaterialTheme.typography.titleMedium,
            placeholder = "Select from multiple options",
            onOptionSelected = { },
            onOptionRemoved = { }
        )
    }
}