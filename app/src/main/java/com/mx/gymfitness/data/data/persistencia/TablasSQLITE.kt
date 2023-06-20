package com.mx.gymfitness.data.persistencia

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="datos")
data class DataEjercicios(
  @PrimaryKey(autoGenerate = true) val id: Int,
  val pesoback: String,
  val pesofront: String,
  val pesooverhead: String,


  val pesostrict: String,
  val pesopushpress: String,
  val pesopushjerk: String,
  val pesosplitjerk: String,
  val pesobench: String,


  val deadlipt: String,

  val cleanspower: String,
  val cleanssquat: String,


  val runnig5k: String,
  val running10k: String,
  val running15k: String,
  val running21k: String,


  val snatchpower: String,
  val snatchsquat: String,


  val sprint100mts: String,
  val sprint400mts: String,


  val frantime: String,


  val gracetime: String,


  val murphtime: String,
  val fecha: String,

  @ColumnInfo(name = "is_completed") val isCompleted: Boolean
)

@Entity(tableName="usuario")
data class Usuario(
  @PrimaryKey(autoGenerate = true) val id: Int,
  val UserName: String,
  val Nombre: String,
  val Tamaño: String,
  val Peso: String,
  @ColumnInfo(name = "is_completed") val isCompleted: Boolean
)
