package com.aniwallshq.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aniwallshq.ui.screens.about.AboutScreen
import com.aniwallshq.ui.screens.detail.DetailScreen
import com.aniwallshq.ui.screens.home.HomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("detail/{wallpaperId}") { backStackEntry ->
            // The wallpaperId will be used to fetch the specific wallpaper details.
            DetailScreen()
        }
        composable("about") { AboutScreen() }
    }
}
