package com.mexiti.cronoapp.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mexiti.cronoapp.repository.ContactsRepository
import com.mexiti.cronoapp.state.ContactState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactoViewModel @Inject constructor(
    private val repository: ContactsRepository) :ViewModel()  {

        var state by mutableStateOf(ContactState())
            private set


    fun getContactById(id:Long){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getContactByID(id).collect{
             item ->
                if(item !=  null){

                    state = state.copy(title = item.title)
                    state = state.copy(apellido =item.apellido)
                    state = state.copy(telefono=item.telefono)
                    state = state.copy(edad = item.edad)
                    state = state.copy(avisar = item.avisar)
                }else{
                    Log.d("Error","El objeto crono es nulo")
                }

            }
        }
    }

    fun onValue1(value:String){
        state = state.copy(title = value)

    }
    fun onValue2(value:String){
        state = state.copy(apellido = value)

    }
    fun onValue3(value: String){
        state = state.copy(telefono = value.toLong())

    }
    fun onValue4(value: String){
        state = state.copy(edad = value.toInt())

    }
    fun onValue5(value: Boolean){
        state = state.copy(avisar = value)

    }




}