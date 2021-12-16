package com.example.myfoodapplication.Model

import java.io.Serializable

data class User(
    val date_of_birth: String,
    val email: String,
    val fb_id: String,
    val gender: String,
    val id: String,
    val name: String,
    val phone: String
): Serializable