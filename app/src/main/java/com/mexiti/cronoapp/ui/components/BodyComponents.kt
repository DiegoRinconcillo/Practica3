package com.mexiti.cronoapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun MainTitle(title: String){
    Text(text= title, color = Color.White, fontWeight = FontWeight.Bold)

}

@Composable
fun MainTextField(value: String,
                  onValueChange: (String) -> Unit,
                  label: String){

    OutlinedTextField(value = value,
        onValueChange =onValueChange,
        label = { Text(text = label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .padding(bottom = 15.dp)
        )
}

@Composable
fun ContactCard(title: String, telefono: String,
                onClick: () -> Unit ) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .clickable {  //The card can used using a click on
                onClick()
            }
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
                )
            Text(text = telefono,
                fontSize = 15.sp
            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp),
                color = MaterialTheme.colorScheme.primary

            )

        }


    }
}




@Preview(showBackground = true, backgroundColor = 2345 )
@Composable
fun MainTitlePreview(){
    MainTitle(title = "CronoApp")
}



    @Preview(showBackground = true)
    @Composable
    fun MainTextfieldPreview(){

        MainTextField(value = "", onValueChange ={} , label = "Score" )

    }


@Preview(showBackground = true)
@Composable
fun ContactCardPreview(){ ContactCard(title = "Cronos", telefono = "2343234") {
        
    }
}
