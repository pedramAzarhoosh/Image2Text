package com.example.image2textapp.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.image2textapp.navigation.Screen
import androidx.compose.ui.Modifier
import com.example.image2textapp.R

@Composable
fun splashScreen(navController: NavHostController){
    splash()
    navController.popBackStack()
    navController.navigate(Screen.Home.route)
}

@Composable
fun splash(){
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(Color.White)) {
        val painterRes = painterResource(id = R.drawable.image_to_text_back)
        Image(painter = painterRes, contentDescription = "splash picture")
    }
}