package com.mexiti.cronoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mexiti.cronoapp.model.Contactos
import kotlinx.coroutines.flow.Flow


@Dao  //Data Access Observer
interface ContactDatabaseDao {
    //Crud
    @Query("SELECT * FROM contactos")
    fun getContacts(): Flow<List<Contactos>>
    @Query("SELECT * FROM contactos Where id=:id")
    fun getContactById(id:Long): Flow<Contactos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contact:Contactos)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(contact:Contactos)
    @Delete
    suspend fun delete(contact:Contactos)

}