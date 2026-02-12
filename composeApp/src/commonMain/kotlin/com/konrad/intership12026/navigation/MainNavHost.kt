package com.konrad.intership12026.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.konrad.intership12026.navigation.bottomnavigation.BottomNavigationBar
import com.konrad.intership12026.navigation.graph.homePageGraph
import com.konrad.intership12026.navigation.graph.sampleNestedGraph

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = RootRoutes.Home,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
        ) {
            homePageGraph(navController)
            sampleNestedGraph(navController)
        }
    }
}