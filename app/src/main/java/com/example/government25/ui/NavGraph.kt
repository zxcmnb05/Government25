package com.example.government25.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.government25.ui.detail.DetailScreen
import com.example.government25.ui.detail.DetailViewModel
import com.example.government25.ui.home.HomeScreen
import com.example.government25.ui.home.HomeViewModel
import com.example.government25.ui.write.WriteScreen
import com.example.government25.ui.write.WriteViewModel

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            val homeViewModel: HomeViewModel = viewModel()
            HomeScreen(
                navController = navController,
                vm = homeViewModel
            )
        }
        composable(route = Screen.Write.route) {
            val writeViewModel: WriteViewModel = viewModel()
            WriteScreen(vm = writeViewModel)
        }
        composable(route = Screen.Detail.route) {
            val detailViewModel: DetailViewModel = viewModel()
            DetailScreen(vm = detailViewModel)
        }
    }
}