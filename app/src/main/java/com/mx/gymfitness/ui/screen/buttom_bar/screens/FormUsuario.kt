package com.mx.gymfitness.ui.screen.buttom_bar.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.firestore.auth.User
import com.mx.gymfitness.data.SquatViewModel
import com.mx.gymfitness.data.persistencia.DataEjercicios
import com.mx.gymfitness.data.persistencia.Usuario
import com.mx.gymfitness.ui.screen.buttom_bar.Items_menu


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FormularioUsuario(navController: NavHostController, viewModel: SquatViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    Text(
                        text = "Registro de Datos del Usuario",
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
            val listTask: List<Usuario> by
            viewModel.allUsuario.observeAsState(listOf())

            if (listTask.isEmpty()) {
                Formulario(navController = navController, viewModel = viewModel)
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(all = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    items(listTask) { item ->
                        DatosUsuario(item)
                    }
                }
            }
        }
    }
}


@Composable
fun Formulario(navController: NavHostController, viewModel: SquatViewModel){
    var usuario by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var tamaño by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }

    val listTask: List<Usuario> by
    viewModel.allUsuario.observeAsState(listOf())

    val scrollState = rememberScrollState()

    Column( modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(scrollState)
        .padding(10.dp, 70.dp, 10.dp, 70.dp)
    ) {
        TextField(
                value = usuario,
                onValueChange = { value ->
                    usuario = value
                },
                label = { Text("Nombre de Usuario") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
        )

            TextField(
                value = nombre,
                onValueChange = { value ->
                    nombre = value
                },
                label = { Text("Nombre de Completo") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )

            TextField(
                value = peso,
                onValueChange = { value ->
                    peso = value
                },
                label = { Text("Peso en Kg") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )

            TextField(
                value = tamaño,
                onValueChange = { value ->
                    tamaño = value
                },
                label = { Text("Altura en Mts") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )

            Button(
                onClick = {
                    val usuarios: Usuario = Usuario(
                        id = 0,
                        UserName = usuario,
                        Nombre = nombre,
                        Tamaño = tamaño,
                        Peso = peso,
                        isCompleted = false
                    )
                    viewModel.createUsuario(usuarios)
                    navController.navigate("Usuario")
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                enabled = usuario.trim().isNotEmpty()&&
                        nombre.trim().isNotEmpty()&&
                        tamaño.trim().isNotEmpty()&&
                        peso.trim().isNotEmpty()
            ) {
                Text("Enviar")
            }
        }
}


@Composable
fun DatosUsuario(item:Usuario){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp, 70.dp, 10.dp, 70.dp))
    {
        Text(text= "Usuario: " +item.UserName)
        Text(text= "Nombre Completo: "+ item.Nombre)
        Text(text= "Peso del Atleta: " + item.Peso + " Kg")
        Text(text= "Altura del Atleta: "+ item.Tamaño + " m")
    }
}