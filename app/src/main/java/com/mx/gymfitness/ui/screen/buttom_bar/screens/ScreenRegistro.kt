package com.mx.gymfitness.ui.screen.buttom_bar.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mx.gymfitness.data.SquatViewModel
import com.mx.gymfitness.data.persistencia.DataEjercicios
import com.mx.gymfitness.data.persistencia.Usuario


@ExperimentalMaterial3Api
@Composable
fun Registro(viewModel: SquatViewModel) {
    val listTask: List<DataEjercicios> by
        viewModel.allEjercicios.observeAsState(listOf())

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if(listTask.isEmpty()) {
            Text(text = "Inicia a realizar un ejercicio\n para comenzar a registrar",
                style = androidx.compose.material.MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
        }else{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
                    .padding(10.dp, 70.dp, 10.dp, 70.dp)
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(all = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    items(listTask) { item ->
                       ItemSquat(item)
                    }
                }
            }
        }
    }
}

@Composable
fun ItemSquat(item:DataEjercicios) {
    val masInformacion = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .clip(shape = androidx.compose.material.MaterialTheme.shapes.small)
            .background(Color(0xFFCEEF25))
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .animateContentSize(
                        animationSpec = tween(70, 0, LinearEasing)
                    )
                    .weight(0.5f)
                    .fillMaxWidth()
            ) {
                androidx.compose.material.Text(
                    text = "Registro del día:\n" + item.fecha,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                    //color = Color.Black
                )
                if (masInformacion.value)
                    androidx.compose.material.Text(
                        text = "Squats: El peso que puede levantar es de:\n" +
                                "Squat Back: " + item.pesoback + "Kg/Lb\n" +
                                "Squat Front: " + item.pesofront + "Kg/Lb\n" +
                                "Squat Over Head:" + item.pesooverhead + "Kg/Lb\n" +
                                "Press: El peso que puede levantar es de:\n" +
                                "Strict Shoulder:" + item.pesostrict + "Kg/Lb\n" +
                                "Push Press:" + item.pesopushpress + "Kg/Lb\n" +
                                "Push Jerk:" + item.pesopushjerk + "Kg/Lb\n" +
                                "Split Jerk:" + item.pesosplitjerk + "Kg/Lb\n" +
                                "Bench Flat Press:" + item.pesobench + "Kg/Lb\n" +
                                "Deadlipt: El peso que puede levantar es de:" +
                                item.deadlipt + "Kg/Lb\n" +
                                "Cleans: El peso que puede levantar es de:\n" +
                                "Power:" + item.cleanspower + "Kg/Lb\n" +
                                "Squat:" + item.cleanssquat + "Kg/Lb\n" +
                                "Snatch: El peso que puede levantar es de:\n" +
                                "Power:" + item.snatchpower + "Kg/Lb\n" +
                                "Squat:" + item.snatchsquat + "Kg/Lb\n" +
                                "Running: Su tiempo es de:\n" +
                                "En 5k:" + item.runnig5k + "(Min/Seg)\n" +
                                "En 10k:" + item.running10k + "(Min/Seg)\n" +
                                "En 15k" + item.running15k + ("Hrs/Min\n") +
                                "En 21k" + item.running21k + ("Hrs/Min\n") +
                                "Sprint: Su tiempo es de:\n" +
                                "100 mts:" + item.sprint100mts + "(Min/Seg)\n" +
                                "400 mts:" + item.sprint400mts + "(Min/Seg)\n" +
                                "Fran: Su tiempo es de:" + item.frantime + "(Min/Seg)\n" +
                                "Grace: Su tiempo es de:" + item.gracetime + "(Min/Seg)\n" +
                                "Murph: Su tiempo es de " + item.murphtime + "(Min/Seg)\n",
                        style = androidx.compose.material.MaterialTheme.typography.body1,
                        //color = Color.Black
                    )
            }
            IconButton(onClick = {
                masInformacion.value = !masInformacion.value
            }) {
                Icon(
                    Icons.Filled.ArrowDropDown,
                    "Icono de Expandir o Colapsar",
                    Modifier.rotate(
                        if (masInformacion.value) 180f else 360f
                    )
                )

            }
        }
    }
}
