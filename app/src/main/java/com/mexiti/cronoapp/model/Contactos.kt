package com.mexiti.cronoapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contactos")
data class Contactos(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "apellido")
    val apellido: String,
    @ColumnInfo(name = "telefono")
    val telefono: Long,
    @ColumnInfo(name = "edad")
    val edad: Int,
    @ColumnInfo(name = "avisar")
    val avisar: Boolean
)

