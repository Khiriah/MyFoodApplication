package com.example.myfoodapplication.network

import com.example.myfoodapplication.Model.Food
import retrofit2.Call
import retrofit2.http.GET

interface FoodService  {
    @GET("food")
    fun  getallFoods(): Call<List<Food>>
}