package com.mexiti.cronoapp.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mexiti.cronoapp.R
import com.mexiti.cronoapp.model.Contactos
import com.mexiti.cronoapp.ui.components.MainIconButton
import com.mexiti.cronoapp.ui.components.MainTextField
import com.mexiti.cronoapp.ui.components.MainTitle
import com.mexiti.cronoapp.viewmodel.ContactoViewModel
import com.mexiti.cronoapp.viewmodel.DataViewModel

@Composable
fun ContentAddView(it:PaddingValues,
                   navController: NavController,
                   contactoVM: ContactoViewModel,
                   dataVM:DataViewModel
                   ){
    val state = contactoVM.state
    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        MainTextField(value = state.title,
                onValueChange = {contactoVM.onValue1(it)}  ,
                label = "Nombre")
        MainTextField(value = state.apellido,
            onValueChange = {contactoVM.onValue2(it)}  ,
            label = "Apellido")
        MainTextField(value = state.telefono.toString(),
            onValueChange = {contactoVM.onValue3(it).toString()}  ,
            label = "Teléfono")
        MainTextField(value = state.edad.toString(),
            onValueChange = {contactoVM.onValue4(it).toString()},
            label = "Edad")
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically){
            Text(text = "Avisar a contacto:", fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Switch(
                checked = state.avisar,
                onCheckedChange = {contactoVM.onValue5(it)}
            )
        }



            Button(onClick = {
                dataVM.addContact(
                    Contactos(title = state.title,
                        apellido=state.apellido,
                        telefono = state.telefono,
                        edad = state.edad,
                        avisar = state. avisar
                        )
                )
                navController.popBackStack()
            }) {
                    Text(text = "Guardar")
            }



    }

}
//AddView(navController:  navegación entre vistas)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddView(navController: NavController,
            contactoVM: ContactoViewModel,
            dataVM: DataViewModel
            ){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { MainTitle(title = stringResource(R.string.add_view) ) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
            
        }
    ) {
        ContentAddView(it = it, navController = navController,contactoVM, dataVM )
    }
}

@Preview
@Composable
fun AddViewPreview(){
    //AddView()
}