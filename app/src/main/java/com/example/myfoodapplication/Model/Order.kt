package com.example.myfoodapplication.Model

import java.io.Serializable

data class Order(
    val id: String,
    val order_date: String,
    val total_price: Int,
    val uesrId: String
): Serializable