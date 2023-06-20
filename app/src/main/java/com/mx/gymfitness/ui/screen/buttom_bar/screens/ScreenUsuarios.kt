package com.mx.gymfitness.ui.screen.buttom_bar.screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Usuario(navController: NavHostController) {
    val auth = FirebaseAuth.getInstance()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            onClick = {navController.navigate("FormularioUsuario") }) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Datos de Usuario", fontSize = 20.sp)
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            onClick = {navController.navigate("FormularioDatosEjercicios") }) {
            Icon(
                imageVector = Icons.Default.Book,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Registro de Ejercicios",fontSize = 20.sp)
        }

        Button( modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            onClick = {
                auth.signOut()
                restartApplication(context)
            }) {
            Icon(
                imageVector = Icons.Default.Logout,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Cerrar Sesión",fontSize = 20.sp)
        }
    }
}

private fun restartApplication(context: Context) {
    val packageManager = context.packageManager
    val intent = packageManager.getLaunchIntentForPackage(context.packageName)
    intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    context.startActivity(intent)
}