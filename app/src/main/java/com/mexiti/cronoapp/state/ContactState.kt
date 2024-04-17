package com.mexiti.cronoapp.state

data class ContactState(
    val title: String = "",
    val apellido: String="",
    val telefono: Long= 0,
    val edad: Int = 0,
    var avisar: Boolean = false
)





