package com.mx.gymfitness.ui.screen.buttom_bar

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mx.gymfitness.data.SquatViewModel
import com.mx.gymfitness.ui.screen.buttom_bar.screens.*

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterial3Api
@Composable
fun NavigationHost(viewModel: SquatViewModel,navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Items_menu.Pantalla1.ruta
    ){
        composable(Items_menu.Pantalla1.ruta){
            Inicio()
        }
        composable(Items_menu.Pantalla2.ruta){
            Registro(viewModel= viewModel)
        }
        composable(Items_menu.Pantalla3.ruta){
            Rutinas(viewModel= viewModel,navController = navController,)
        }
        composable("Usuario"){
            Usuario(navController= navController)
        }
        composable("FormularioDatosEjercicios"){
            FormRutinas(navController = navController, viewModel = viewModel)
        }
        composable("FormularioUsuario"){
            FormularioUsuario(navController= navController, viewModel= viewModel)
        }
    }
}