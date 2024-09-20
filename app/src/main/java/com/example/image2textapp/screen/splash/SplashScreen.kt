package com.example.image2textapp.screen.splash

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.image2textapp.navigation.Screen
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.image2textapp.R

@Composable
fun splashScreen(navController: NavHostController){
    splash()
}

@Composable
fun splash(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        , modifier = Modifier.background(Color.White)) {
        Box(contentAlignment = Alignment.Center) {
            val painterRes = painterResource(id = R.drawable.image_to_text_back)
            val imageModifier = Modifier
                .size(200.dp)

            Image(painter = painterRes, contentDescription = "splash picture",
                contentScale = ContentScale.Fit,
                modifier = imageModifier)
        }
    }
}