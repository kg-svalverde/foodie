package com.konrad.intership12026.feature.homepage.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.feature.homepage.state.HomePageState
import com.konrad.intership12026.model.SampleAppModel

@Composable
fun HomePageLayout(state: HomePageState) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(items = state.information) {
                SampleItem(sampleModel = it)
            }
        }
    }
}

@Composable
fun SampleItem(sampleModel: SampleAppModel, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(all = 16.dp)) {
        Text(sampleModel.name)
        Text(sampleModel.description)
    }
}
