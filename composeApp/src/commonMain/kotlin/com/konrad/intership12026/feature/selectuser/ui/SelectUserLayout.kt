package com.konrad.intership12026.feature.selectuser.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konrad.intership12026.components.cards.AppUserCard
import com.konrad.intership12026.data.AppData
import com.konrad.intership12026.data.UserModel
import com.konrad.intership12026.feature.selectuser.model.SelectUserState
import com.konrad.intership12026.ui.theme.AppTheme
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.foodie
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectUserLayout(
    viewState: SelectUserState,
    onUserSelected: (UserModel) -> Unit

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(92.dp))
        Image(
            painter = painterResource(Res.drawable.foodie),
            contentDescription = "App's logo: Foodie",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(86.dp)
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "Users",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = AppTheme.colors.black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Who's ready to eat smart?",
                style = MaterialTheme.typography.labelLarge,
                color = AppTheme.colors.black,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            FlowRow (
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxSize(),
                maxItemsInEachRow = 3,
                horizontalArrangement = Arrangement.Center
            ){
                viewState.users.forEach {
                    AppUserCard(
                        modifier = Modifier
                            .padding(8.dp),
                        name = it.firstName,
                        image = it.profilePic,
                        onClick = { onUserSelected(it) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun SelectUserLayoutPreview() {
    AppTheme {
        SelectUserLayout(
            viewState = SelectUserState(AppData.users),
            onUserSelected = { }
        )
    }
}
