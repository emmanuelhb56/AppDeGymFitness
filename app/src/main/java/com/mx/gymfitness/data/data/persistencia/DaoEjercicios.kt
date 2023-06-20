package com.mx.gymfitness.data.persistencia

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface DaoEjercicios {
    @Query("SELECT * FROM datos")
    fun getAllEjercicios(): LiveData<List<DataEjercicios>>

    @Insert
    fun insertEjercicios(vararg dataEjercicios: DataEjercicios)

    @Update
    fun updateEjercicios(vararg dataEjercicios: DataEjercicios)

    @Delete
    fun deleteEjercicios(vararg dataEjercicios: DataEjercicios)
}

@Dao
interface DaoUsuario {
    @Query("SELECT * FROM usuario")
    fun getAllUsuario(): LiveData<List<Usuario>>

    @Insert
    fun insertUsuario(vararg usuario: Usuario)

    @Update
    fun updatePress(vararg usuario: Usuario)

    @Delete
    fun deletePress(usuario: Usuario)
}