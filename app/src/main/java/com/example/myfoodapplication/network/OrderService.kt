package com.example.myfoodapplication.network

import com.example.myfoodapplication.Model.Food
import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.Model.Product
import retrofit2.Call
import retrofit2.http.*

interface OrderService {
    @POST("uesrs/{id}/order")
    fun creatOrder(@Path ("id")userId:String,@Body order: Order): Call<Order>
}




