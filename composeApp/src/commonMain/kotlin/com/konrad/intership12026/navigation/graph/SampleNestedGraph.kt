package com.konrad.intership12026.navigation.graph

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.konrad.intership12026.navigation.RootRoutes
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.nestedScreen
import intership12026.composeapp.generated.resources.secondTab
import intership12026.composeapp.generated.resources.secondTab_cta
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.stringResource

fun NavGraphBuilder.sampleNestedGraph(navController: NavController) {
    navigation<RootRoutes.SampleNested>(startDestination = SampleNestedRoutes.FirstScreen) {
        composable<SampleNestedRoutes.FirstScreen> {
            Column {
                Text(stringResource(Res.string.secondTab))
                Button(onClick = {
                    navController.navigate(SampleNestedRoutes.NestedScreen)
                }) {
                    Text(stringResource(Res.string.secondTab_cta))
                }
            }
        }
        composable<SampleNestedRoutes.NestedScreen> {
            Text(stringResource(Res.string.nestedScreen))
        }
    }
}

@Serializable
sealed class SampleNestedRoutes {
    @Serializable
    object FirstScreen : SampleNestedRoutes()
    @Serializable
    object NestedScreen : SampleNestedRoutes()
}