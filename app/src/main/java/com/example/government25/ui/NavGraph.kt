package com.example.government25.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.government25.ui.detail.DetailScreen
import com.example.government25.ui.home.HomeScreen
import com.example.government25.ui.write.WriteScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Write.route) {
            WriteScreen()
        }
        composable(route = Screen.Detail.route) {
            DetailScreen()
        }
    }
}