package com.konrad.intership12026.feature.marketmap.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.feature.marketmap.model.MarketMapState
import com.konrad.intership12026.ui.theme.AppTheme

@Composable
fun MarketMapLayout(
    viewState: MarketMapState,
    onButtonClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .padding(top = 48.dp)
        ) {
            Text(
                text = "Market Map",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = AppTheme.colors.black
            )
            Text(
                text = "Find healthy ingredients near you",
                style = MaterialTheme.typography.bodyMedium,
                color = AppTheme.colors.gray
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        
        // Map content will go here
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 32.dp)
                .background(AppTheme.colors.lightGray, shape = RoundedCornerShape(24.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Map view placeholder", color = AppTheme.colors.gray)
        }
        
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun MarketMapLayoutPreview() {
    AppTheme {
        MarketMapLayout(
            viewState = MarketMapState("")
        )
    }
}
