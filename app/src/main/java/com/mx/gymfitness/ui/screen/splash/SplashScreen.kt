package com.mx.gymfitness.ui.screen.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.mx.gymfitness.R
import com.mx.gymfitness.ui.screen.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
){
    val scale = remember{
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true){
        scale.animateTo(targetValue = 0.9f,
            animationSpec = tween(durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                }
            ),
        )
        delay(3500L)
        //navController.navigate(Screens.LoginScreen.name)
        if(FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()){
            navController.navigate(Screens.LoginScreen.name)
        }else{
            navController.navigate(Screens.HomeScreen.name){
                popUpTo(Screens.SplashScreen.name){
                    inclusive = true
                }
            }
        }
    }

    val color = MaterialTheme.colors.primary
    Surface(modifier = Modifier
        .padding(15.dp)
        .size(430.dp)
        .scale(scale.value),
        //shape = CircleShape,
        color = Color.Black
        //border = BorderStroke(width = 2.dp, color = color)
    ) {
        Column(modifier = Modifier
            .padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(280.dp),painter = painterResource(id = R.drawable.icono_sinfondo) ,
                contentDescription = "Icono")

            Text("DeGymFitness",
                style = MaterialTheme.typography.h3,
                color = Color.White.copy(alpha = 0.5f),
                fontWeight = FontWeight.Bold,
            )
            Spacer(Modifier.size(5.dp))
            Text("El verdadero fracaso es renunciar",
                style = MaterialTheme.typography.h6,
                color = Color(0xFFCEEF25),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}