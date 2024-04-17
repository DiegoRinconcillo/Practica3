package com.mexiti.cronoapp.repository

import com.mexiti.cronoapp.model.Contactos
import com.mexiti.cronoapp.room.ContactDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ContactsRepository@Inject constructor(private val contactDatabaseDao:ContactDatabaseDao) {
    suspend fun addContact(contact: Contactos ) = contactDatabaseDao.insert(contact)
    suspend fun updateContact(contact: Contactos) = contactDatabaseDao.update(contact = contact)
    suspend fun deleteContact(contact: Contactos) = contactDatabaseDao.delete(contact = contact)

    fun getAllcontacts(): Flow<List<Contactos>> = contactDatabaseDao
        .getContacts()
        .flowOn(Dispatchers.IO)
        .conflate()

    fun getContactByID(id:Long):Flow<Contactos> = contactDatabaseDao
        .getContactById(id)
        .flowOn(Dispatchers.IO)
        .conflate()
}

