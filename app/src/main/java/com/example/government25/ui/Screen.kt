package com.example.government25.ui

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Write: Screen(route = "write _screen")
    object Detail: Screen(route = "detail _screen")
}
