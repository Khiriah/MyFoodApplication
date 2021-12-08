package com.example.myfoodapplication.viewModel

import java.io.Serializable

data class Food(
    val FoodDescription: String,
    val FoodImage: String,
    val FoodName: String,
    val FoodPrice: String,
    val FoodState: Boolean,
    val fId: String,
    val pId: String
): Serializable