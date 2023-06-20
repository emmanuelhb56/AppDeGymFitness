package com.mx.gymfitness.model

import androidx.compose.runtime.Composable
import com.mx.gymfitness.R

sealed class Ejercicios(
    var nombre: String,
    var tipo: String,
    var tamaño: Int,
    var subtamaño: Int,
    var imagen: Int,
    var ruta: String
){
    object squatsback: Ejercicios(" SQUAT BACK","SQUAT",29,17 ,R.drawable.back, "FormularioSquatsBack")
    object squatsfront:Ejercicios(" SQUAT FRONT","SQUAT",28,17 ,R.drawable.front, "FormularioSquatsFront")
    object squatsoverhead:Ejercicios(" OVER HEAD","SQUAT",29,17 ,R.drawable.overhead, "FormularioSquatsOverHead")

    object strictshoulder: Ejercicios(" STRICT\nSHOULDER","PRESS",29, 17,R.drawable.stricshoulder, "FormularioPressShoulder")
    object pushpress:Ejercicios(" PUSH PRESS","PRESS",29, 17,R.drawable.pushpress,"FormularioPressPush")
    object splitjerk:Ejercicios(" SPLIT JERK","PRESS",29,17,R.drawable.splitjerk,"FormularioPressSplitJerk")
    object benchflatpress: Ejercicios(" BENCH FLAT","PRESS",29,17,R.drawable.benchflatpress,"FormularioPressBenchFlat")

}
