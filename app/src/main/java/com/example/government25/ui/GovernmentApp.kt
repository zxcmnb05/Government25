package com.example.government25.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.government25.ui.detail.DetailScreen
import com.example.government25.ui.detail.DetailViewModel
import com.example.government25.ui.home.HomeScreen
import com.example.government25.ui.home.HomeViewModel
import com.example.government25.ui.login.LoginScreen
import com.example.government25.ui.login.LoginViewModel
import com.example.government25.ui.theme.Government25Theme
import com.example.government25.ui.write.WriteScreen
import com.example.government25.ui.write.WriteViewModel

@Composable
fun GovernmentApp() {
    Government25Theme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.Login.route) {
            composable(Screen.Home.route) {
                HomeScreen(
                    vm = HomeViewModel(),
                    selectPost = {
                        navController.navigate("${Screen.Detail.route}/$it")
                    },
                    clickWrite = {
                        navController.navigate(Screen.Write.route)
                    }
                )
            }
            composable(Screen.Write.route) {
                WriteScreen(vm = WriteViewModel())
            }
            composable(
                route = Screen.Detail.routeWithArgument,
                arguments = listOf(
                    navArgument(Screen.Detail.argument) { type = NavType.IntType }
                )
            ) {
                val postId =
                    it.arguments?.getInt(Screen.Detail.argument) ?: return@composable

                DetailScreen(postId = postId, vm = DetailViewModel())
            }
            composable(Screen.Login.route) {
                LoginScreen(vm = LoginViewModel(),
                    clickLogin = {
                        navController.navigate(Screen.Home.route)
                    }
                )
            }
        }
    }
}

sealed class Screen(val route: String) {
    object Home : Screen(route = "Home")

    object Write : Screen(route = "Write")

    object Login : Screen(route = "Login")

    object Detail : Screen(route = "Detail") {
        const val routeWithArgument: String = "Detail/{postId}"
        const val argument: String = "postId"
    }
}
