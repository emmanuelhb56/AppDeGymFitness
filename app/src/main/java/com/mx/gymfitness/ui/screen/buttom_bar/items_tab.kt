package com.mx.gymfitness.ui.screen.buttom_bar

import com.mx.gymfitness.R
sealed class Items_menu(
    val Icon: Int,
    val title: String,
    val ruta: String
){
    object  Pantalla1: Items_menu(R.drawable.baseline_home_24,
        "Inicio", "pantalla1")
    object  Pantalla2: Items_menu(R.drawable.baseline_library_books_24,
        "Registros", "pantalla2")
    object Pantalla3: Items_menu(R.drawable.baseline_directions_run_24,
        "Rutinas","pantalla3")
}
