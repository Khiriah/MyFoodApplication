package com.example.myfoodapplication.Model

import java.io.Serializable

data class User(
    val Email: String,
    val Name: String,
    val Phone: Int,
    val uId: String
): Serializable