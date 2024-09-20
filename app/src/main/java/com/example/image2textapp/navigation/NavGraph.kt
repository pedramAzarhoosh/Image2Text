package com.example.image2textapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


@Composable
fun setupNavGraph(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = Screen.Splash.route ){
        composable(route = Screen.Splash.route) {

        }
        composable(route = Screen.Home.route) {

        }
    }
}