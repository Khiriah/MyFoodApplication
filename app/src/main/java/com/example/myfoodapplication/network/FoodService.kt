package com.example.myfoodapplication.network

import com.example.myfoodapplication.Model.Food
import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.Model.Product
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FoodService  {
//    @GET("suppliers/{id}/products")
//    fun getMenueById(@Path("id") id:String): Call<List<Food>>
    @GET("suppliers/{id}/products")
    fun  getMenueById(@Path("id")supplierId:String ): Call<List<Food>>
}