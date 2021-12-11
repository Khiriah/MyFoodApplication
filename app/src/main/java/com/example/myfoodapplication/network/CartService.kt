package com.example.myfoodapplication.network

import com.example.myfoodapplication.Model.Cart
import com.example.myfoodapplication.Model.Food
import retrofit2.Call
import retrofit2.http.GET

interface CartService {
    @GET("cart")
    fun getallCarts(): Call<List<Cart>>
    @GET("Food")
    fun getbyid():Call<List<Food>>
}