package com.example.myfoodapplication.network

import com.example.myfoodapplication.Model.Product
import com.example.myfoodapplication.Model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ProductService {
    @POST("uesrs/{id}/order/{id}/Product")
    fun addItemToProduct(@Body product: Product): Call<Product>
}