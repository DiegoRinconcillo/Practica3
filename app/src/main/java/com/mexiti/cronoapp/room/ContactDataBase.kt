package com.mexiti.cronoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mexiti.cronoapp.model.Contactos


@Database(entities = [Contactos::class], version = 1, exportSchema = false)
abstract class ContactDataBase:RoomDatabase() {
    abstract fun contactDao():ContactDatabaseDao
}