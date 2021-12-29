package com.example.myfoodapplication.network

import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.Model.Product
import com.example.myfoodapplication.Model.Supplier
import com.example.myfoodapplication.Model.User
import retrofit2.Call
import retrofit2.http.*

interface ProductService {
    @POST("uesrs/{id}/order/{oid}/Product")
    fun addItemToProduct(@Path("id")userId:String,@Path("oid")orderId:String, @Body product: Product): Call<Product>
    @GET("uesrs/{id}/order/{oid}/Product")
    fun  getProductById(@Path("id")userId:String,@Path("oid")orderId:String ): Call<List<Product>>
}