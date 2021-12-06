package com.example.myfoodapplication.viewModel

import java.io.Serializable

class Food(
    var id: String? = null,
    val FoodName: String,
    var pId: String,
    var FoodPrice:String,
    val FoodState: Boolean?,
    val Fooddescription: String,
    val ImageFood:String
) : Serializable