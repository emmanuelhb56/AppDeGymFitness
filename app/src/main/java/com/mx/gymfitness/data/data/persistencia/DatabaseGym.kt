package com.mx.gymfitness.data.data.persistencia

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mx.gymfitness.data.persistencia.DaoEjercicios
import com.mx.gymfitness.data.persistencia.DaoUsuario
import com.mx.gymfitness.data.persistencia.DataEjercicios
import com.mx.gymfitness.data.persistencia.Usuario


@Database(entities = [DataEjercicios::class, Usuario::class], version = 1)
abstract class DatabaseGym: RoomDatabase() {
    abstract fun getDaoEjercicios(): DaoEjercicios
    abstract fun getDaoUsuario(): DaoUsuario

    companion object{
        private var INSTANCE: DatabaseGym? = null

        fun getInstance(context: Context): DatabaseGym{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room
                        .databaseBuilder(
                            context = context,
                            klass = DatabaseGym::class.java,
                            name = "db_gym"
                        ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}