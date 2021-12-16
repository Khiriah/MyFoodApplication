package com.example.myfoodapplication.network

import com.example.myfoodapplication.Model.Supplier
import retrofit2.Call
import retrofit2.http.GET

interface SupplierService {
    @GET("suppliers")
    fun  getallPersons(): Call<List<Supplier>>
}