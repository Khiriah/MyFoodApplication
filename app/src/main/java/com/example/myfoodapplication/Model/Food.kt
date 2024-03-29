package com.example.myfoodapplication.Model

import java.io.Serializable

data class Food(
    val category: String,
    val description: String,
    val id: String,
    val name: String,
    val photo: String,
    val price: String,
    val quantity: Int,
    val supplierId: String
): Serializable