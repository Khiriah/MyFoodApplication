package com.example.myfoodapplication.viewModel

import java.io.Serializable

data class Cart(
    val cId: String,
    val fId: String,
    val uId: String
): Serializable