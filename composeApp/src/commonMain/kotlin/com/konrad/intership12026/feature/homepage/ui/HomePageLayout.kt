package com.konrad.intership12026.feature.homepage.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.feature.homepage.model.HomePageState

@Composable
fun HomePageLayout(
    viewState: HomePageState,
    onButtonClick: () -> Unit = {},
) {
    Column {
        LazyColumn(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            /*items(items = viewState.information) {
                SampleItem(sampleModel = it)
            }*/
        }
        HorizontalDivider(
            thickness = 2.dp,
        )
        Button(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onClick = onButtonClick
        ) {
            Text(text = "Navigate to Profile")
        }
    }
}

@Composable
fun SampleItem(
    //sampleModel: SampleAppModel,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp),
            text = "", // sampleModel.name
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(16.dp),
            text = "", //sampleModel.description
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun HomePageLayoutPreview() {
    /*val sampleModel = SampleAppModel(
        name = "Sample Name",
        description = "Sample Description"
    )*/

    HomePageLayout(
        viewState = HomePageState("")
    )
}
