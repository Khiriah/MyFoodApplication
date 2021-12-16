package com.example.myfoodapplication.Model

import java.io.Serializable

data class Product(
    val category: String,
    val createdAt: String,
    val description: String,
    val id: String,
    val name: String,
    val orderId: String,
    val photo: String,
    val price: String,
    val quantity: Int
): Serializable