package com.example.myfoodapplication.Model

import java.io.Serializable

data class Cart(
    val cId: String,
    val fId: String,
    val uId: String
): Serializable