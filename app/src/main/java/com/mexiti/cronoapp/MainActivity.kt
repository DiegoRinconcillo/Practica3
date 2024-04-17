package com.mexiti.cronoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.mexiti.cronoapp.navigation.NavManager
import com.mexiti.cronoapp.viewmodel.ContactoViewModel
import com.mexiti.cronoapp.viewmodel.DataViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contactoVM:ContactoViewModel by viewModels()
        val dataVM:DataViewModel by viewModels()
        setContent {
                NavManager(contactoVM,dataVM)
        }
    }
}

