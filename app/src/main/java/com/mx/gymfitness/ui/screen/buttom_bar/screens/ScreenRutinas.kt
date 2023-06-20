package com.mx.gymfitness.ui.screen.buttom_bar.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import com.mx.gymfitness.data.SquatViewModel
import com.mx.gymfitness.model.NavigationEjercicios


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Rutinas(viewModel: SquatViewModel,navController: NavHostController) {
    Column(
       horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        NavigationEjercicios(viewModel = viewModel)
    }
}
