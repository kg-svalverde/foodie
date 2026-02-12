package com.konrad.intership12026.navigation.bottomnavigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.konrad.intership12026.navigation.RootRoutes
import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.home
import intership12026.composeapp.generated.resources.secondTab
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

val bottomNavigationItems = listOf(
    BottomNavigationItem(
        label = Res.string.home,
        icon = Res.drawable.home,
        route = RootRoutes.Home
    ),
    BottomNavigationItem(
        label = Res.string.secondTab,
        icon = Res.drawable.home,
        route = RootRoutes.SampleNested
    ),
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        bottomNavigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    navController.navigate(route = item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    selectedIndex = index
                },
                icon = {
                    Icon(
                        painterResource(item.icon),
                        contentDescription = stringResource(item.label)
                    )
                },
                label = { Text(stringResource(item.label)) }
            )
        }
    }
}