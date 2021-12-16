package com.example.myfoodapplication.Model

import java.io.Serializable

data class Supplier(
    val food_types: String,
    val id: String,
    val logo: String,
    val name: String,
    val rating: String
):Serializable