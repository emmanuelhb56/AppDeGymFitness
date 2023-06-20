package com.mx.gymfitness.model

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.os.Build
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.mx.gymfitness.R
import com.mx.gymfitness.data.SquatViewModel
import com.mx.gymfitness.data.persistencia.DataEjercicios
import com.mx.gymfitness.ui.screen.buttom_bar.screens.ItemSquat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun Squats(viewModel: SquatViewModel,navController: NavHostController) {

    val Ejercicios = listOf(
        Ejercicios.squatsback,
        Ejercicios.squatsfront,
        Ejercicios.squatsoverhead
    )

    val Tabs = listOf(
        TiposEjercicios.Squats,
        TiposEjercicios.Press,
        TiposEjercicios.Deadlipt,
        TiposEjercicios.Cleans,
        TiposEjercicios.Snatch,
        TiposEjercicios.Running,
        TiposEjercicios.Sprint,
        TiposEjercicios.Fran,
        TiposEjercicios.Grace,
        TiposEjercicios.Murph
    )

    Column() {
        Spacer(modifier = Modifier.size(15.dp))
        Column( modifier = Modifier
            .padding(horizontal = 18.dp)) {
            Tabs(Tabs = Tabs, navController = navController)
        }
        Spacer(modifier = Modifier.size(15.dp))
        ComponenteRutinas(Ejercicios, navController)
    }
}

@Composable
fun Press(viewModel: SquatViewModel, navController: NavHostController) {

    val Ejercicios = listOf(
        Ejercicios.strictshoulder,
        Ejercicios.pushpress,
        Ejercicios.splitjerk,
        Ejercicios.benchflatpress
    )

    val Tabs = listOf(
        TiposEjercicios.Squats,
        TiposEjercicios.Press,
        TiposEjercicios.Deadlipt,
        TiposEjercicios.Cleans,
        TiposEjercicios.Snatch,
        TiposEjercicios.Running,
        TiposEjercicios.Sprint,
        TiposEjercicios.Fran,
        TiposEjercicios.Grace,
        TiposEjercicios.Murph
    )
    Column() {
        Spacer(modifier = Modifier.size(15.dp))
        Column( modifier = Modifier
            .padding(horizontal = 18.dp)) {
            Tabs(Tabs = Tabs, navController = navController)
        }
        Spacer(modifier = Modifier.size(15.dp))
        ComponenteRutinas(Ejercicios, navController)
    }
}

@Composable
fun Cleans(viewModel: SquatViewModel,navController: NavHostController) {
    val Tabs = listOf(
        TiposEjercicios.Squats,
        TiposEjercicios.Press,
        TiposEjercicios.Deadlipt,
        TiposEjercicios.Cleans,
        TiposEjercicios.Snatch,
        TiposEjercicios.Running,
        TiposEjercicios.Sprint,
        TiposEjercicios.Fran,
        TiposEjercicios.Grace,
        TiposEjercicios.Murph
    )

    Column() {
        Spacer(modifier = Modifier.size(15.dp))
        Column( modifier = Modifier
            .padding(horizontal = 18.dp)) {
            Tabs(Tabs = Tabs, navController = navController)
        }
        Spacer(modifier = Modifier.size(15.dp))

    }
}

@Composable
fun Snatch(viewModel: SquatViewModel,navController: NavHostController) {
    val Tabs = listOf(
        TiposEjercicios.Squats,
        TiposEjercicios.Press,
        TiposEjercicios.Deadlipt,
        TiposEjercicios.Cleans,
        TiposEjercicios.Snatch,
        TiposEjercicios.Running,
        TiposEjercicios.Sprint,
        TiposEjercicios.Fran,
        TiposEjercicios.Grace,
        TiposEjercicios.Murph
    )

    Column() {
        Spacer(modifier = Modifier.size(15.dp))
        Column( modifier = Modifier
            .padding(horizontal = 18.dp)) {
            Tabs(Tabs = Tabs, navController = navController)
        }
        Spacer(modifier = Modifier.size(15.dp))

    }
}

@Composable
fun Deadlipt(viewModel: SquatViewModel,navController: NavHostController) {
    val Tabs = listOf(
        TiposEjercicios.Squats,
        TiposEjercicios.Press,
        TiposEjercicios.Deadlipt,
        TiposEjercicios.Cleans,
        TiposEjercicios.Snatch,
        TiposEjercicios.Running,
        TiposEjercicios.Sprint,
        TiposEjercicios.Fran,
        TiposEjercicios.Grace,
        TiposEjercicios.Murph
    )

    Column() {
        Spacer(modifier = Modifier.size(15.dp))
        Column( modifier = Modifier
            .padding(horizontal = 18.dp)) {
            Tabs(Tabs = Tabs, navController = navController)
        }
        Spacer(modifier = Modifier.size(15.dp))
    }
}

@Composable
fun Grace(viewModel: SquatViewModel,navController: NavHostController) {
    val Tabs = listOf(
        TiposEjercicios.Squats,
        TiposEjercicios.Press,
        TiposEjercicios.Deadlipt,
        TiposEjercicios.Cleans,
        TiposEjercicios.Snatch,
        TiposEjercicios.Running,
        TiposEjercicios.Sprint,
        TiposEjercicios.Fran,
        TiposEjercicios.Grace,
        TiposEjercicios.Murph
    )

    Column() {
        Spacer(modifier = Modifier.size(15.dp))
        Column( modifier = Modifier
            .padding(horizontal = 18.dp)) {
            Tabs(Tabs = Tabs, navController = navController)
        }
        Spacer(modifier = Modifier.size(15.dp))

    }
}

@Composable
fun Runinng(viewModel: SquatViewModel,navController: NavHostController) {
    val Tabs = listOf(
        TiposEjercicios.Squats,
        TiposEjercicios.Press,
        TiposEjercicios.Deadlipt,
        TiposEjercicios.Cleans,
        TiposEjercicios.Snatch,
        TiposEjercicios.Running,
        TiposEjercicios.Sprint,
        TiposEjercicios.Fran,
        TiposEjercicios.Grace,
        TiposEjercicios.Murph
    )

    Column() {
        Spacer(modifier = Modifier.size(15.dp))
        Column( modifier = Modifier
            .padding(horizontal = 18.dp)) {
            Tabs(Tabs = Tabs, navController = navController)
        }
        Spacer(modifier = Modifier.size(15.dp))

    }
}

@Composable
fun Fran(viewModel: SquatViewModel,navController: NavHostController) {
    val Tabs = listOf(
        TiposEjercicios.Squats,
        TiposEjercicios.Press,
        TiposEjercicios.Deadlipt,
        TiposEjercicios.Cleans,
        TiposEjercicios.Snatch,
        TiposEjercicios.Running,
        TiposEjercicios.Sprint,
        TiposEjercicios.Fran,
        TiposEjercicios.Grace,
        TiposEjercicios.Murph
    )

    Column() {
        Spacer(modifier = Modifier.size(15.dp))
        Column( modifier = Modifier
            .padding(horizontal = 18.dp)) {
            Tabs(Tabs = Tabs, navController = navController)
        }
        Spacer(modifier = Modifier.size(15.dp))

    }
}

@Composable
fun Murph(viewModel: SquatViewModel,navController: NavHostController) {
    val Tabs = listOf(
        TiposEjercicios.Squats,
        TiposEjercicios.Press,
        TiposEjercicios.Deadlipt,
        TiposEjercicios.Cleans,
        TiposEjercicios.Snatch,
        TiposEjercicios.Running,
        TiposEjercicios.Sprint,
        TiposEjercicios.Fran,
        TiposEjercicios.Grace,
        TiposEjercicios.Murph
    )

    Column() {
        Spacer(modifier = Modifier.size(15.dp))
        Column( modifier = Modifier
            .padding(horizontal = 18.dp)) {
            Tabs(Tabs = Tabs, navController = navController)
        }
        Spacer(modifier = Modifier.size(15.dp))

    }
}

@Composable
fun Sprint(viewModel: SquatViewModel,navController: NavHostController) {
    val Tabs = listOf(
        TiposEjercicios.Squats,
        TiposEjercicios.Press,
        TiposEjercicios.Deadlipt,
        TiposEjercicios.Cleans,
        TiposEjercicios.Snatch,
        TiposEjercicios.Running,
        TiposEjercicios.Sprint,
        TiposEjercicios.Fran,
        TiposEjercicios.Grace,
        TiposEjercicios.Murph
    )

    Column() {
        Spacer(modifier = Modifier.size(15.dp))
        Column( modifier = Modifier
            .padding(horizontal = 18.dp)) {
            Tabs(Tabs = Tabs, navController = navController)
        }
        Spacer(modifier = Modifier.size(15.dp))
    }
}

@Composable
fun ComponenteRutinas(Ejercicios:List<Ejercicios>, navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp)
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ){
            items(Ejercicios){ ejercicios->
                CarEjercicio(ejercicios,navController)
            }
        }
    }
}



@Composable
fun CarEjercicio(item: Ejercicios, navController: NavHostController){
    Box(
        modifier = Modifier
            .padding(10.dp, 10.dp, 10.dp, 10.dp)
            .size(310.dp, 410.dp)
            .clip(RoundedCornerShape(10))
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 22.dp)
        ) {
            Spacer(modifier = Modifier.size(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = item.nombre,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = item.tamaño.sp
                )
                Spacer(modifier = Modifier.weight(0.3f))
                Button(
                    shape = RoundedCornerShape(20.dp),
                    contentPadding = PaddingValues(6.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Color(0xFFCEEF25)
                    )
                ) {
                    Text(text = item.tipo,
                        color = Color.Black,
                        fontSize = item.subtamaño.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }

            Spacer(modifier = Modifier.size(5.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Black)
            ) {
                Image(
                    painter = painterResource(id = item.imagen),
                    contentDescription = "Dummy weight image",
                    modifier = Modifier.size(260.dp,245.dp)
                )

            }

           Spacer(modifier = Modifier.size(5.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Spacer(modifier = Modifier.weight(0.5f))

                TextButton(
                    onClick = {
                        navController.navigate(item.ruta)
                    }, colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Color.Transparent
                    )
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                        Text(
                            text = "Empezar",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFCEEF25)
                        )

                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            modifier = Modifier.size(30.dp),
                            contentDescription = "Timer",
                            tint = Color(0xFFCEEF25)
                        )
                    }
                }
            }

        }
    }
}



@Composable
fun Tabs(Tabs:List<TiposEjercicios>, navController: NavHostController){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(Tabs){ tabs->
            TabsType(tabs,navController)
        }
    }
}


@Composable
fun TabsType(Tabs: TiposEjercicios,navController: NavHostController) {
    var selected by remember { mutableStateOf(false) }
    val backgroundColor = if (selected) Color.White else Color.Black
    val textColor = if (selected) Color.Black else Color.White

    OutlinedButton(
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(6.dp),
        border = BorderStroke(width = 1.dp, color = Color.Black),
        onClick = { selected = !selected; navController.navigate(Tabs.Ruta) },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = backgroundColor,
        )
    ) {
        Text(text = Tabs.Titulo, color = textColor, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}


@TargetApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun FormRutinasSquatsBack(viewModel: SquatViewModel,navController: NavHostController) {
    val listTask: List<DataEjercicios> by
    viewModel.allEjercicios.observeAsState(listOf())

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    androidx.compose.material3.Text(
                        text = "Ejercicios de Squats Back",
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("Squats")
                    }) {
                        androidx.compose.material3.Icon(
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
                .fillMaxSize()
        ) {
            if(listTask.isEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                        .padding(10.dp, 70.dp, 10.dp, 70.dp),
                ) {
                    Text(
                        "Por favor, dirigete a la pantalla de usuario para registrar tu progreso",
                        textAlign = TextAlign.Center, color=Color.Black
                    )
                }
            }else {
                LazyColumn(
                    contentPadding = PaddingValues(all = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(listTask) { item ->
                        DatosEjerciciosSquatBack(item)
                    }
                }
            }
        }
    }
}

@Composable
fun DatosEjerciciosSquatBack(item:DataEjercicios){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(10.dp, 70.dp, 10.dp, 70.dp),
    ) {
        var percentage by remember { mutableStateOf("") }
        val result = remember { derivedStateOf {
            val num = item.pesoback.toDoubleOrNull() ?: 0.0
            val percent = percentage.toDoubleOrNull() ?: 0.0
            val value = (num * percent) / 100
            value
        } }
        Text("Peso que carga de Backs: " + item.pesoback + " Kg/Lb", color = Color.Black)

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = percentage,
            onValueChange = { value ->
                percentage = value
            },
            label = { Text("Porcentaje") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Text("Resultado de carga por Back: ${result.value} Kg/Lb", textAlign = TextAlign.Center, color = Color.Black)

    }
}


@TargetApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun FormRutinasSquatsFront(viewModel: SquatViewModel,navController: NavHostController) {
    val listTask: List<DataEjercicios> by
    viewModel.allEjercicios.observeAsState(listOf())

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    androidx.compose.material3.Text(
                        text = "Ejercicios de Squats Front",
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("Squats")
                    }) {
                        androidx.compose.material3.Icon(
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
                .fillMaxSize()
        ) {
            if(listTask.isEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                        .padding(10.dp, 70.dp, 10.dp, 70.dp),
                ) {
                    Text(
                        "Por favor, dirigete a la pantalla de usuario para registrar tu progreso",
                        textAlign = TextAlign.Center, color=Color.Black
                    )
                }
            }else {
                LazyColumn(
                    contentPadding = PaddingValues(all = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    items(listTask) { item ->
                        DatosEjerciciosFront(item)
                    }
                }
            }
        }
    }
}

@Composable
fun DatosEjerciciosFront(item:DataEjercicios){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(10.dp, 70.dp, 10.dp, 70.dp),
    ) {
        var percentage by remember { mutableStateOf("") }
        val result = remember { derivedStateOf {
            val num = item.pesofront.toDoubleOrNull() ?: 0.0
            val percent = percentage.toDoubleOrNull() ?: 0.0
            val value = (num * percent) / 100
            value
        } }
        Text("Peso que carga de Front: " +item.pesofront +" Kg/Lb", color = Color.Black)

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = percentage,
            onValueChange = { value ->
                percentage = value
            },
            label = { Text("Porcentaje") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Text("Resultado: ${result.value} Kg/Lb", textAlign = TextAlign.Center, color = Color.Black)

    }
}

@TargetApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun FormRutinasSquatsOverHead(viewModel: SquatViewModel,navController: NavHostController) {
    val listTask: List<DataEjercicios> by
    viewModel.allEjercicios.observeAsState(listOf())

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    androidx.compose.material3.Text(
                        text = "Ejercicios de Squats Over Head",
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("Squats")
                    }) {
                        androidx.compose.material3.Icon(
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
                .fillMaxSize()
        ) {
            if(listTask.isEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                        .padding(10.dp, 70.dp, 10.dp, 70.dp),
                ) {
                    Text(
                        "Por favor, dirigete a la pantalla de usuario para registrar tu progreso",
                        textAlign = TextAlign.Center, color=Color.Black
                    )
                }
            }else {
                LazyColumn(
                    contentPadding = PaddingValues(all = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    items(listTask) { item ->
                        DatosEjerciciosOverHead(item)
                    }
                }
            }
        }
    }
}

@Composable
fun DatosEjerciciosOverHead(item:DataEjercicios){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(10.dp, 70.dp, 10.dp, 70.dp),
    ) {
        var percentage by remember { mutableStateOf("") }
        val result = remember { derivedStateOf {
            val num = item.pesooverhead.toDoubleOrNull() ?: 0.0
            val percent = percentage.toDoubleOrNull() ?: 0.0
            val value = (num * percent) / 100
            value
        } }
        Text("Peso que carga de Over Head: " +item.pesooverhead +" Kg/Lb", color = Color.Black)

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = percentage,
            onValueChange = { value ->
                percentage = value
            },
            label = { Text("Porcentaje") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Text("Resultado: ${result.value} Kg/Lb", textAlign = TextAlign.Center, color = Color.Black)

    }
}


@TargetApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun FormRutinasPressStrictShoulder(viewModel: SquatViewModel,navController: NavHostController) {
    val listTask: List<DataEjercicios> by
    viewModel.allEjercicios.observeAsState(listOf())

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    androidx.compose.material3.Text(
                        text = "Ejercicios de Strict Shoulder",
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("Press")
                    }) {
                        androidx.compose.material3.Icon(
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
                .fillMaxSize()
        ) {
            if(listTask.isEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                        .padding(10.dp, 70.dp, 10.dp, 70.dp),
                ) {
                    Text(
                        "Por favor, dirigete a la pantalla de usuario para registrar tu progreso",
                        textAlign = TextAlign.Center, color=Color.Black
                    )
                }
            }else {
                LazyColumn(
                    contentPadding = PaddingValues(all = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    items(listTask) { item ->
                        DatosEjerciciosStrictShoulder(item)
                    }
                }
            }
        }
    }
}

@Composable
fun DatosEjerciciosStrictShoulder(item:DataEjercicios){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(10.dp, 70.dp, 10.dp, 70.dp),
    ) {
        var percentage by remember { mutableStateOf("") }
        val result = remember { derivedStateOf {
            val num = item.pesostrict.toDoubleOrNull() ?: 0.0
            val percent = percentage.toDoubleOrNull() ?: 0.0
            val value = (num * percent) / 100
            value
        } }
        Text("Peso que carga de Strict Shoulder: " +item.pesostrict +" Kg/Lb", color = Color.Black)

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = percentage,
            onValueChange = { value ->
                percentage = value
            },
            label = { Text("Porcentaje") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Text("Resultado: ${result.value} Kg/Lb", textAlign = TextAlign.Center, color = Color.Black)

    }
}

@TargetApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun FormRutinasPressPushPress(viewModel: SquatViewModel,navController: NavHostController) {
    val listTask: List<DataEjercicios> by
    viewModel.allEjercicios.observeAsState(listOf())

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    androidx.compose.material3.Text(
                        text = "Ejercicios de Push Press",
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("Press")
                    }) {
                        androidx.compose.material3.Icon(
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
                .fillMaxSize()
        ) {
            if(listTask.isEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                        .padding(10.dp, 70.dp, 10.dp, 70.dp),
                ) {
                    Text(
                        "Por favor, dirigete a la pantalla de usuario para registrar tu progreso",
                        textAlign = TextAlign.Center, color=Color.Black
                    )
                }
            }else {
                LazyColumn(
                    contentPadding = PaddingValues(all = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    items(listTask) { item ->
                        DatosEjerciciosPushPress(item)
                    }
                }
            }
        }
    }
}

@Composable
fun DatosEjerciciosPushPress(item:DataEjercicios){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(10.dp, 70.dp, 10.dp, 70.dp),
    ) {
        var percentage by remember { mutableStateOf("") }
        val result = remember { derivedStateOf {
            val num = item.pesopushpress.toDoubleOrNull() ?: 0.0
            val percent = percentage.toDoubleOrNull() ?: 0.0
            val value = (num * percent) / 100
            value
        } }
        Text("Peso que carga de Push Press: " +item.pesopushpress +" Kg/Lb", color = Color.Black)

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = percentage,
            onValueChange = { value ->
                percentage = value
            },
            label = { Text("Porcentaje") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Text("Resultado: ${result.value} Kg/Lb", textAlign = TextAlign.Center, color = Color.Black)

    }
}

@TargetApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun FormRutinasPressSplitJerk(viewModel: SquatViewModel,navController: NavHostController) {
    val listTask: List<DataEjercicios> by
    viewModel.allEjercicios.observeAsState(listOf())

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    androidx.compose.material3.Text(
                        text = "Ejercicios de Split Jerk",
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("Press")
                    }) {
                        androidx.compose.material3.Icon(
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
                .fillMaxSize()
        ) {
            if(listTask.isEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                        .padding(10.dp, 70.dp, 10.dp, 70.dp),
                ) {
                    Text(
                        "Por favor, dirigete a la pantalla de usuario para registrar tu progreso",
                        textAlign = TextAlign.Center, color=Color.Black
                    )
                }
            }else {
                LazyColumn(
                    contentPadding = PaddingValues(all = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    items(listTask) { item ->
                        DatosEjerciciosSplitJerk(item)
                    }
                }
            }
        }
    }
}

@Composable
fun DatosEjerciciosSplitJerk(item:DataEjercicios){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(10.dp, 70.dp, 10.dp, 70.dp),
    ) {
        var percentage by remember { mutableStateOf("") }
        val result = remember { derivedStateOf {
            val num = item.pesosplitjerk.toDoubleOrNull() ?: 0.0
            val percent = percentage.toDoubleOrNull() ?: 0.0
            val value = (num * percent) / 100
            value
        } }
        Text("Peso que carga de Split Jerk: " +item.pesosplitjerk +" Kg/Lb", color = Color.Black)

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = percentage,
            onValueChange = { value ->
                percentage = value
            },
            label = { Text("Porcentaje") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Text("Resultado: ${result.value} Kg/Lb", textAlign = TextAlign.Center, color = Color.Black)

    }
}

@TargetApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun FormRutinasPressBenchFlat(viewModel: SquatViewModel,navController: NavHostController) {
    val listTask: List<DataEjercicios> by
    viewModel.allEjercicios.observeAsState(listOf())

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    androidx.compose.material3.Text(
                        text = "Ejercicios de Bench Flat",
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("Press")
                    }) {
                        androidx.compose.material3.Icon(
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
                .fillMaxSize()
        ) {
            if(listTask.isEmpty()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                        .padding(10.dp, 70.dp, 10.dp, 70.dp),
                ) {
                    Text(
                        "Por favor, dirigete a la pantalla de usuario para registrar tu progreso",
                        textAlign = TextAlign.Center, color=Color.Black
                    )
                }
            }else {
                LazyColumn(
                    contentPadding = PaddingValues(all = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    items(listTask) { item ->
                        DatosEjerciciosBenchFlat(item)
                    }
                }
            }
        }
    }
}

@Composable
fun DatosEjerciciosBenchFlat(item:DataEjercicios){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(10.dp, 70.dp, 10.dp, 70.dp),
    ) {
        var percentage by remember { mutableStateOf("") }
        val result = remember { derivedStateOf {
            val num = item.pesobench.toDoubleOrNull() ?: 0.0
            val percent = percentage.toDoubleOrNull() ?: 0.0
            val value = (num * percent) / 100
            value
        } }
        Text("Peso que carga de Bench Flat: " +item.pesobench +" Kg/Lb", color = Color.Black)

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = percentage,
            onValueChange = { value ->
                percentage = value
            },
            label = { Text("Porcentaje") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Text("Resultado: ${result.value} Kg/Lb", textAlign = TextAlign.Center, color = Color.Black)

    }
}