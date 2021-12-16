package com.example.myfoodapplication.network

import com.example.myfoodapplication.Model.Food
import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.Model.Product
import retrofit2.Call
import retrofit2.http.*

interface OrderService {

//    @GET("Product/{id}")
//    fun getCartById(@Path("id") id:String): Call<Product>

//
    @POST("uesrs/{id}/order")
    fun addItemToOrder(@Body order: Order): Call<Order>


//    @DELETE("order/{id}")
//    fun deleteCart(): Call<Order>



}




