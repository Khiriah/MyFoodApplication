package com.example.myfoodapplication.viewModel

import java.io.Serializable

class Person (
    var idPerson: String? = null,
    val namePerson: String,
    var TypePerson:String,
    var RatingPerson:String,
    val StatePerson: Boolean?,
    val ImagePerson:String
) : Serializable