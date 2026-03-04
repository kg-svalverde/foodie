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
import com.konrad.intership12026.components.cards.AppUserCard
import com.konrad.intership12026.data.AppData
import com.konrad.intership12026.feature.selectuser.model.SelectUserState
import com.konrad.intership12026.ui.theme.AppTheme
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.foodie
import intership12026.composeapp.generated.resources.user1
import intership12026.composeapp.generated.resources.user2
import intership12026.composeapp.generated.resources.user3
import intership12026.composeapp.generated.resources.user4
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

data class User(
    val name: String,
    val profilePic: DrawableResource
) {
    companion object {
        val dummies = listOf(
            User("George", Res.drawable.user1),
            User("Rebecca", Res.drawable.user2),
            User("Kev", Res.drawable.user3),
            User("Andrew", Res.drawable.user4)
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectUserLayout(
    viewState: SelectUserState,
    onButtonClick: () -> Unit = {}
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

        Spacer(modifier = Modifier.height(24.dp))

        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "Users",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp, start = 32.dp, end = 32.dp),
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = AppTheme.colors.black
            )
            FlowRow (
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(),
                maxItemsInEachRow = 3,
                horizontalArrangement = Arrangement.Center
            ){
                viewState.users.forEach {
                    AppUserCard(
                        modifier = Modifier
                            .padding(8.dp),
                        name = it.firstName,
                        image = it.profilePic,
                        onClick = { /* .. */ }
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
            onButtonClick = { }
        )
    }
}
