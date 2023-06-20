package com.mx.gymfitness

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.mx.gymfitness.data.SquatViewModel
import com.mx.gymfitness.data.SquatViewModelFactory
import com.mx.gymfitness.ui.screen.navigation.GymFitnessNavigation
import com.mx.gymfitness.ui.theme.AppDeGymFitnessTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val owner =
                LocalViewModelStoreOwner.current

            AppDeGymFitnessTheme {
                owner?.let {
                    val viewModel: SquatViewModel =
                        viewModel(
                            it,
                            "SquatViewModel",
                            SquatViewModelFactory(
                                application = this.application
                            )
                        )
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        GymFitnessApp(viewModel = viewModel)
                    }
                }
            }
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun GymFitnessApp(viewModel: SquatViewModel) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.Black
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GymFitnessNavigation(viewModelSquat = viewModel)
            }
        }
    }
}

