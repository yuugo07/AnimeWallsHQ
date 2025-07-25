package com.aniwallshq.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.aniwallshq.ui.screens.about.AboutScreen
import com.aniwallshq.ui.screens.detail.DetailScreen
import com.aniwallshq.ui.screens.detail.DetailViewModel
import com.aniwallshq.ui.screens.home.HomeScreen
import com.aniwallshq.ui.screens.settings.SettingsScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("detail/{wallpaperId}") { backStackEntry ->
            val viewModel: DetailViewModel = hiltViewModel(backStackEntry)
            DetailScreen(viewModel)
        }
        composable("about") { AboutScreen() }
        composable("settings") { SettingsScreen() }
    }
}
