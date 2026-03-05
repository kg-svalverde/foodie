package com.konrad.intership12026.feature.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
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
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
            .verticalScroll(rememberScrollState()),
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
            value = viewState.email,
            onValueChange = onEmailChange,
            placeholder = "Enter your email",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        AppTextField(
            value = viewState.password,
            onValueChange = onPasswordChange,
            placeholder = "Enter your password",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth()
        )

        if (viewState.errorMessage != null) {
            Text(
                text = viewState.errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp).fillMaxWidth()
            )
        } else {
            Spacer(modifier = Modifier.height(24.dp))
        }

        AppButton(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            onClick = onLoginClick,
            variant = ButtonVariant.Base
        ) {
            Text(text = "Continue")
        }

        // The "Hyperlink" Sign Up Text
        val signUpText = buildAnnotatedString {
            append("Don't have an account? ")
            withStyle(style = SpanStyle(
                color = AppTheme.colors.secondary,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            ) {
                append("Sign up")
            }
        }

        Text(
            text = signUpText,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.clickable { onSignUpClick() }
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun LoginLayoutPreview() {
    AppTheme {
        LoginLayout(
            viewState = LoginState(),
            onEmailChange = {},
            onPasswordChange = {},
            onLoginClick = {},
            onSignUpClick = {}
        )
    }
}
