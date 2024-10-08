package com.example.image2textapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.image2textapp.screen.home.homeScreen
import com.example.image2textapp.screen.scanner.scannerScreen
import com.example.image2textapp.screen.splash.splashScreen


@Composable
fun setupNavGraph(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = Screen.Splash.route ){
        composable(route = Screen.Splash.route) {
            splashScreen(navController)
        }
        composable(route = Screen.Home.route) {
            homeScreen()
        }
        composable(route = Screen.ScannerScr.route){
            scannerScreen()
        }
    }
}