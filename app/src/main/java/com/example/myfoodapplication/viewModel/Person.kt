package com.example.myfoodapplication.viewModel

import java.io.Serializable

class Person (
    var idPerson: String? = null,
    var Price:Int,
    val namePerson: String,
    val StatePerson: Boolean?,
    val descriptionPerson: String,
    val ImagePerson:String
) : Serializable