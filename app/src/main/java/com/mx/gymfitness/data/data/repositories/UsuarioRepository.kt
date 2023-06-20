package com.mx.gymfitness.data.data.repositories

import androidx.lifecycle.LiveData
import com.mx.gymfitness.data.persistencia.DaoUsuario
import com.mx.gymfitness.data.persistencia.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UsuarioRepository(private val daoUsuario: DaoUsuario) {

    private val coroutineScope =
        CoroutineScope(Dispatchers.Main)

    val allUsuario:LiveData<List<Usuario>>
        =daoUsuario.getAllUsuario()

    fun createUsuario(usuario: Usuario){
        coroutineScope.launch(Dispatchers.IO) {
            daoUsuario.insertUsuario(usuario)
        }
    }

    fun updateUsuario(usuario: Usuario){
        coroutineScope.launch(Dispatchers.IO) {
           daoUsuario.updatePress(usuario)
        }
    }

    fun deleteUsuario(usuario: Usuario){
        coroutineScope.launch(Dispatchers.IO) {
           daoUsuario.deletePress(usuario)
        }
    }
}