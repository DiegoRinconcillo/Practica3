package com.mexiti.cronoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mexiti.cronoapp.model.Contactos
import com.mexiti.cronoapp.repository.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(

    private val repository:ContactsRepository):ViewModel() {
        private val _contactList = MutableStateFlow<List<Contactos>>(emptyList())
    val contactlist = _contactList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {

            repository.getAllcontacts().collect{
                item  ->
                if (item.isNullOrEmpty()){
                    _contactList.value = emptyList()
                }else{
                    _contactList.value = item
                }
            }
        }

    }
    fun addContact(contact:Contactos) = viewModelScope.launch { repository.addContact(contact) }
    fun updateContact(contact:Contactos) = viewModelScope.launch { repository.updateContact(contact) }
    fun deleteContact(contact: Contactos) = viewModelScope.launch { repository.deleteContact(contact) }

}