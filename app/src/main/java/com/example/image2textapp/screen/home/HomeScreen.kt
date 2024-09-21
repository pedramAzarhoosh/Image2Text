package com.example.image2textapp.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.image2textapp.R

@Composable
fun homeScreen(){
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {
        val painterRes = painterResource(id = R.drawable.ic_launcher_background)
        Image(painter = painterRes, contentDescription = null,
            Modifier.size(320.dp).clip(RoundedCornerShape(20.dp)))

        Row (Modifier.fillMaxWidth().padding(top = 50.dp, start = 50.dp)){
            Text(text = "hello", fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontWeight = FontWeight.Bold)
        }


        Row (modifier = Modifier.fillMaxWidth().padding(top = 20.dp), horizontalArrangement = Arrangement.Center,){
            OutlinedButton(onClick = { /*TODO*/ }, shape = RoundedCornerShape(5.dp),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp)) {
                Text(text = "Take a snap")
            }
        }

        Row (modifier = Modifier.fillMaxWidth().padding(top = 0.dp), horizontalArrangement = Arrangement.Center,){
            OutlinedButton(onClick = { /*TODO*/ }, shape = RoundedCornerShape(5.dp),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp)) {
                Text(text = "Detect the text")
            }
        }

    }
}


@Preview
@Composable
fun home(){
    homeScreen()
}