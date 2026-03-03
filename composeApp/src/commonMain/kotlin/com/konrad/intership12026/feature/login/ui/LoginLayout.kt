package com.konrad.intership12026.feature.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konrad.intership12026.components.buttons.AppButton
import com.konrad.intership12026.components.buttons.ButtonVariant
import com.konrad.intership12026.components.inputs.AppTextField
import com.konrad.intership12026.feature.login.model.LoginState
import com.konrad.intership12026.ui.theme.AppTheme
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.foodie
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoginLayout(
    viewState: LoginState,
    onButtonClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(48.dp))

        Image(
            painter = painterResource(Res.drawable.foodie),
            contentDescription = "App's logo: Foodie",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(80.dp)
                .padding(bottom = 32.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Log in to your account",
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = AppTheme.colors.black
        )

        Text(
            text = "Please sign in to continue",
            style = MaterialTheme.typography.bodyMedium,
            color = AppTheme.colors.gray,
            modifier = Modifier.padding(bottom = 40.dp)
        )

        AppTextField(
            value = "",
            onValueChange = {},
            placeholder = "Enter your email",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        AppTextField(
            value = "",
            onValueChange = {},
            placeholder = "Enter your password",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        AppButton(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            onClick = onButtonClick,
            variant = ButtonVariant.Base
        ) {
            Text(text = "Continue")
        }


        Text(
            text = "Don't have an account? Sign up",
            style = MaterialTheme.typography.bodyMedium,
            color = AppTheme.colors.secondary,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun LoginLayoutPreview() {
    AppTheme {
        LoginLayout(
            viewState = LoginState("")
        )
    }
}
