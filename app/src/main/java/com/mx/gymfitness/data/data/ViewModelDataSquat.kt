package com.mx.gymfitness.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mx.gymfitness.data.data.persistencia.DatabaseGym
import com.mx.gymfitness.data.data.repositories.EjerciciosRepository
import com.mx.gymfitness.data.data.repositories.UsuarioRepository
import com.mx.gymfitness.data.persistencia.DataEjercicios
import com.mx.gymfitness.data.persistencia.Usuario


class SquatViewModel(application: Application): ViewModel(){
    private val usuarioRepository : UsuarioRepository
    private val ejerciciosRepository : EjerciciosRepository

    val allUsuario: LiveData<List<Usuario>>
    val allEjercicios: LiveData<List<DataEjercicios>>
    init{
        val gymDB = DatabaseGym.getInstance(
            application.applicationContext)

        usuarioRepository= UsuarioRepository(gymDB.getDaoUsuario())
        ejerciciosRepository = EjerciciosRepository(gymDB.getDaoEjercicios())

        allUsuario = usuarioRepository.allUsuario
        allEjercicios = ejerciciosRepository.allEjercicios
    }

    fun createUsuario(usuario: Usuario){
        usuarioRepository.createUsuario(usuario)
    }

    fun updateUsuario(usuario: Usuario){
        usuarioRepository.updateUsuario(usuario)
    }

    fun deleteUsuario(usuario: Usuario){
       usuarioRepository.deleteUsuario(usuario)
    }

    fun createEjercicio(ejercicios: DataEjercicios){
        ejerciciosRepository.createEjercicios(ejercicios)
    }

    fun updateEjercicios(ejercicios: DataEjercicios){
        ejerciciosRepository.updateEjercicios(ejercicios)
    }

    fun deleteEjercicios(ejercicios: DataEjercicios){
        ejerciciosRepository.deleteEjercicios(ejercicios)
    }
}
class SquatViewModelFactory(
    val application: Application)
    : ViewModelProvider.Factory{

    override fun <T : ViewModel>
            create(modelClass: Class<T>)
            : T {
        return SquatViewModel(
            application = application) as T
    }
}