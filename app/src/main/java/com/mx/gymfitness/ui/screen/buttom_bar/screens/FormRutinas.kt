package com.mx.gymfitness.ui.screen.buttom_bar.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.style.TextAlign
import com.mx.gymfitness.data.SquatViewModel
import com.mx.gymfitness.data.persistencia.DataEjercicios
import com.mx.gymfitness.ui.screen.buttom_bar.Items_menu
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FormRutinas(navController: NavHostController, viewModel: SquatViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    Text(
                        text = "Registro de Ejercicios",
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Items_menu.Pantalla1.ruta)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.Black
                        )
                    }
                }
            )
        },
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier
                .fillMaxSize(),
        ) {
            var back by remember { mutableStateOf("") }
            var front by remember { mutableStateOf("") }
            var overhead by remember { mutableStateOf("") }

            var strictShoulder by remember { mutableStateOf("") }
            var pushpress by remember { mutableStateOf("") }
            var pushjerk by remember { mutableStateOf("") }
            var splitjerk by remember { mutableStateOf("") }
            var benchflat by remember { mutableStateOf("") }

            var deadlipt by remember { mutableStateOf("") }

            var cleanspower by remember { mutableStateOf("") }
            var cleansquat by remember { mutableStateOf("") }

            var snatchpower by remember { mutableStateOf("") }
            var snatchsquat by remember { mutableStateOf("") }

            var running5k by remember { mutableStateOf("") }
            var running10k by remember { mutableStateOf("") }
            var running15k by remember { mutableStateOf("") }
            var running21k by remember { mutableStateOf("") }

            var sprint100mts by remember { mutableStateOf("") }
            var sprint400mts by remember { mutableStateOf("") }

            var fran by remember { mutableStateOf("") }
            var grace by remember { mutableStateOf("") }
            var murph by remember { mutableStateOf("") }

            val fechaActual = LocalDate.now()
            val formato = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            val fechaActualComoString = fechaActual.format(formato)

            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
                    .padding(10.dp,70.dp,10.dp,70.dp)
                ) {
                val listTask: List<DataEjercicios> by
                viewModel.allEjercicios.observeAsState(listOf())
                TextField(
                    value = back,
                    onValueChange = { value ->
                        back = value
                    },
                    label = { Text("Peso cargado por Back en Lb/Kg") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = front,
                    onValueChange = { value ->
                        front = value
                    },
                    label = { Text("Peso cargado por Front en Lb/Kg") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = overhead,
                    onValueChange = { value ->
                        overhead = value
                    },
                    label = { Text("Peso cargado por Over Head en Lb/Kg") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = strictShoulder,
                    onValueChange = { value ->
                        strictShoulder = value
                    },
                    label = { Text("Peso cargado por Strict Shoulder en Lb/Kg") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = pushpress,
                    onValueChange = { value ->
                        pushpress = value
                    },
                    label = { Text("Peso cargado por Push Press en Lb/Kg") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = pushjerk,
                    onValueChange = { value ->
                        pushjerk = value
                    },
                    label = { Text("Peso cargado por Push Jerk en Lb/Kg") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = splitjerk,
                    onValueChange = { value ->
                        splitjerk = value
                    },
                    label = { Text("Peso cargado por Split Jerk en Lb/Kg") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = benchflat,
                    onValueChange = { value ->
                        benchflat = value
                    },
                    label = { Text("Peso cargado por Bench Flat en Lb/Kg") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = deadlipt,
                    onValueChange = { value ->
                        deadlipt = value
                    },
                    label = { Text("Peso cargado por Deadlipt en Lb/Kg") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = cleanspower,
                    onValueChange = { value ->
                        cleanspower = value
                    },
                    label = { Text("Peso cargado por Cleans Power en Lb/Kg") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = cleansquat,
                    onValueChange = { value ->
                        cleansquat = value
                    },
                    label = { Text("Peso cargado por Cleans Squat en Lb/Kg") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = snatchpower,
                    onValueChange = { value ->
                        snatchpower = value
                    },
                    label = { Text("Peso cargado por Snatch Power en Lb/Kg") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = snatchsquat,
                    onValueChange = { value ->
                        snatchsquat = value
                    },
                    label = { Text("Peso cargado por Snatch Squat en Lb/Kg") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = running5k,
                    onValueChange = { value ->
                        running5k = value
                    },
                    label = { Text("Tiempo que corre 5k en Min/Seg") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = running10k,
                    onValueChange = { value ->
                        running10k = value
                    },
                    label = { Text("Tiempo que corre 10k en Min/Seg") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )


                TextField(
                    value = running15k,
                    onValueChange = { value ->
                        running15k = value
                    },
                    label = { Text("Tiempo que corre 15k en Min/Seg") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                TextField(
                    value = running21k,
                    onValueChange = { value ->
                        running21k = value
                    },
                    label = { Text("Tiempo que corre 21k en Min/Seg") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = sprint100mts,
                    onValueChange = { value ->
                        sprint100mts = value
                    },
                    label = { Text("Tiempo de Sprint en 100 mts mtsen Min/Seg") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = sprint400mts,
                    onValueChange = { value ->
                        sprint400mts = value
                    },
                    label = { Text("Tiempo de Sprint en 400 mts en Min/Seg") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = fran,
                    onValueChange = { value ->
                        fran = value
                    },
                    label = { Text("Tiempo de Fran en Min/Seg") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = grace,
                    onValueChange = { value ->
                        grace = value
                    },
                    label = { Text("Tiempo de Grace en Min/Seg") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                TextField(
                    value = murph,
                    onValueChange = { value ->
                        murph = value
                    },
                    label = { Text("Tiempo de Murph Min/Seg") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                Button(
                    onClick = {
                        val squat: DataEjercicios = DataEjercicios(
                            id = 0,
                            pesoback = back,
                            pesofront = front,
                            pesooverhead = overhead,
                            fecha = fechaActualComoString,

                            pesostrict = strictShoulder,
                            pesopushpress = pushpress,
                            pesopushjerk = pushjerk,
                            pesosplitjerk = splitjerk,
                            pesobench = benchflat,

                            deadlipt = deadlipt,

                            cleanspower = cleanspower,
                            cleanssquat = cleansquat,

                            runnig5k = running5k,
                            running10k = running10k,
                            running15k = running15k,
                            running21k = running21k,

                            snatchpower = snatchpower,
                            snatchsquat = snatchsquat,

                            sprint100mts = sprint100mts,
                            sprint400mts = sprint400mts,


                            frantime = fran,

                            gracetime = grace,

                            murphtime = murph,

                            isCompleted = false
                        )
                        viewModel.createEjercicio(squat)
                        navController.navigate("Usuario")
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    enabled = back.trim().isNotEmpty() &&
                            front.trim().isNotEmpty() &&
                            overhead.trim().isNotEmpty() &&
                            strictShoulder.trim().isNotEmpty()&&
                            pushpress.trim().isNotEmpty() &&
                            pushjerk.trim().isNotEmpty() &&
                            splitjerk.trim().isNotEmpty() &&
                            benchflat.trim().isNotEmpty() &&
                            deadlipt.trim().isNotEmpty() &&
                            cleanspower.trim().isNotEmpty() &&
                            cleansquat.trim().isNotEmpty() &&
                            snatchpower.trim().isNotEmpty() &&
                            snatchsquat.trim().isNotEmpty() &&
                            running5k.trim().isNotEmpty() &&
                            running10k.trim().isNotEmpty() &&
                            running15k.trim().isNotEmpty() &&
                            running21k.trim().isNotEmpty() &&
                            sprint100mts.trim().isNotEmpty() &&
                            sprint400mts.trim().isNotEmpty() &&
                            fran.trim().isNotEmpty()&&
                            grace.trim().isNotEmpty()&&
                            murph.trim().isNotEmpty()
                ) {
                    Text("Enviar")
                }
            }
        }
    }
}