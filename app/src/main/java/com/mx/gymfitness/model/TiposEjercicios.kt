package com.mx.gymfitness.model

sealed class TiposEjercicios(
    var Titulo: String,
    var Ruta : String
){
    object Squats: TiposEjercicios("Squats","Squats")
    object Press: TiposEjercicios("Press","Press")
    object Cleans: TiposEjercicios("Cleans","Cleans")
    object Deadlipt: TiposEjercicios("Deadlipt","Deadlipt")
    object Snatch: TiposEjercicios("Snatch","Snatch")
    object Running: TiposEjercicios("Running","Running")
    object Sprint: TiposEjercicios("Sprint","Sprint")
    object Fran: TiposEjercicios("Fran","Fran")
    object Grace: TiposEjercicios("Grace","Grace")
    object Murph: TiposEjercicios("Murph","Murph")
}