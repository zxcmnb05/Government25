package com.example.government25.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.government25.ui.theme.Government25Theme

@Composable
fun GovernmentApp() {
    Government25Theme {
        val navController = rememberNavController()
        NavGraph(navController = navController)
    }
}