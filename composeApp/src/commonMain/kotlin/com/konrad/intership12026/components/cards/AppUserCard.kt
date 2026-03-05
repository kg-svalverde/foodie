package com.konrad.intership12026.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.ui.theme.AppTheme
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.user3
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppUserCard(
    onClick: () -> Unit,
    name: String,
    image: DrawableResource,
    // user: User,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .size(width = 80.dp, height = 120.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            onClick = onClick,
            colors = CardDefaults.cardColors(
                containerColor = AppTheme.colors.background,
            ),
            modifier = Modifier
                .size(width = 80.dp, height = 80.dp)
                .fillMaxWidth()
                .padding(top = 0.75.dp)
        ) {
            Image(
                painter = painterResource(image), // user.profile_pic
                contentDescription = "User's profile picture",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.Center)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun AppUserCardPreview() {
    val image: DrawableResource = Res.drawable.user3

    AppTheme {
        AppUserCard(onClick = {}, name = "John Doe", image = image)
    }
}
