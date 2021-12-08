package com.example.myfoodapplication.network

import retrofit2.http.GET

interface CartServies {
    @GET("Carts")
    fun getallCarts()
}