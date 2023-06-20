package com.mx.gymfitness.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mx.gymfitness.data.SquatViewModel
import com.mx.gymfitness.ui.screen.buttom_bar.screens.FormRutinas


@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterial3Api
@Composable
fun NavigationEjercicios(viewModel: SquatViewModel){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Squats"
    ){
        composable("Squats"){
            Squats(viewModel = viewModel,navController =navController)
        }
        composable("Press") {
            Press(viewModel = viewModel,navController = navController)
        }
        composable("Deadlipt"){
            Deadlipt(viewModel= viewModel,navController = navController)
        }
        composable("Cleans"){
            Cleans(viewModel = viewModel, navController = navController)
        }
        composable("Snatch"){
            Snatch(viewModel = viewModel,navController = navController)
        }
        composable("Running"){
            Runinng(viewModel = viewModel, navController = navController)
        }
        composable("Sprint"){
            Sprint(viewModel = viewModel,navController = navController)
        }
        composable("Fran"){
            Fran(viewModel = viewModel, navController = navController)
        }
        composable("Grace"){
            Grace(viewModel= viewModel, navController=navController)
        }
        composable("Murph"){
            Murph(viewModel = viewModel, navController=navController)
        }
        composable("FormularioSquatsBack"){
            FormRutinasSquatsBack(viewModel = viewModel, navController = navController)
        }
        composable("FormularioSquatsFront"){
            FormRutinasSquatsFront(viewModel = viewModel, navController = navController)
        }
        composable("FormularioSquatsOverHead"){
            FormRutinasSquatsOverHead(viewModel = viewModel, navController = navController)
        }
        composable("FormularioPressShoulder"){
            FormRutinasPressStrictShoulder(viewModel = viewModel, navController = navController)
        }
        composable("FormularioPressPush"){
            FormRutinasPressPushPress(viewModel = viewModel, navController = navController)
        }
        composable("FormularioPressSplitJerk"){
            FormRutinasPressSplitJerk(viewModel = viewModel, navController = navController)
        }
        composable("FormularioPressBenchFlat"){
            FormRutinasPressBenchFlat(viewModel = viewModel, navController = navController)
        }

    }
}

