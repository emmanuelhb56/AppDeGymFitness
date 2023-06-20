package com.mx.gymfitness.ui.screen.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mx.gymfitness.data.SquatViewModel
import com.mx.gymfitness.ui.screen.home.Home
import com.mx.gymfitness.ui.screen.login.LoginScreenViewModel
import com.mx.gymfitness.ui.screen.login.LoginScreen
import com.mx.gymfitness.ui.screen.splash.SplashScreen

@ExperimentalMaterial3Api
@Composable
fun GymFitnessNavigation(viewModelSquat: SquatViewModel){
    val navController = rememberNavController()
    val viewModel = LoginScreenViewModel()
    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.name
    ) {
        composable(Screens.SplashScreen.name){
            SplashScreen( navController = navController)
        }
        composable(Screens.LoginScreen.name){
            LoginScreen( viewModel = viewModel, navHost =navController )
        }
        composable(Screens.HomeScreen.name){
            Home(viewModel =viewModelSquat , navController = navController)
        }
    }
}
