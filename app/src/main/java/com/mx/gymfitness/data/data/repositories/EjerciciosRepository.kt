package com.mx.gymfitness.data.data.repositories

import androidx.lifecycle.LiveData
import com.mx.gymfitness.data.persistencia.DaoEjercicios
import com.mx.gymfitness.data.persistencia.DataEjercicios


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EjerciciosRepository(
    private val daoEjercicios: DaoEjercicios
    ) {

    private val coroutineScope =
        CoroutineScope(Dispatchers.Main)

    val allEjercicios: LiveData<List<DataEjercicios>>
            = daoEjercicios.getAllEjercicios()

    fun createEjercicios(dataEjercicios: DataEjercicios){
        coroutineScope.launch(Dispatchers.IO){
            daoEjercicios.insertEjercicios(dataEjercicios)
        }
    }

    fun updateEjercicios(dataEjercicios: DataEjercicios){
        coroutineScope.launch (Dispatchers.IO) {
            daoEjercicios.updateEjercicios(dataEjercicios)
        }
    }

    fun deleteEjercicios(dataEjercicios: DataEjercicios){
        coroutineScope.launch(Dispatchers.IO){
            daoEjercicios.deleteEjercicios(dataEjercicios)
        }
    }
}
