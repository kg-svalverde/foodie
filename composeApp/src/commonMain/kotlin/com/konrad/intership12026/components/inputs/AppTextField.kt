package com.konrad.intership12026.components.inputs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.ui.theme.AppTheme

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    style: TextStyle,
    placeholder: String = "",
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    val appColors = AppTheme.colors

    Column(modifier = modifier) {
        // show label only if provided
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
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = placeholder,
                    color = appColors.gray,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
            },
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            isError = isError,
            keyboardOptions = keyboardOptions,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = appColors.primary,
                unfocusedBorderColor = appColors.lightGray,
                focusedContainerColor = appColors.background,
                unfocusedContainerColor = appColors.background,
                cursorColor = appColors.primary
            )
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun AppTextFieldPreview() {
    AppTheme {
        AppTextField(
            value = "1.82",
            onValueChange = {  },
            label = "Height",
            placeholder = "height",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}