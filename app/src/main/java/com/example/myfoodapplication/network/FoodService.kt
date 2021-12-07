package com.example.myfoodapplication.network

import retrofit2.http.GET

interface FoodService {
    @GET("Foods")
    fun  getallFoods()

}