package com.example.image2textapp.navigation

sealed class Screen (val route: String) {
    object Splash : Screen("splash_screen")
    object Home: Screen("home_screen")

    object ScannerScr: Screen("scanner_screen")
}