package com.example.myfoodapplication.viewModel

import java.io.Serializable

class Food(
    var id: String? = null,
    val name: String,
    var pId: String,
    var Price:Int,
    val State: Boolean?,
    val description: String,
    val ImageFood:String
) : Serializable