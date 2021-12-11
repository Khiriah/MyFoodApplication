package com.example.myfoodapplication.network

import com.example.myfoodapplication.Model.Person
import retrofit2.Call
import retrofit2.http.GET

interface PersonService {
    @GET("Person")
    fun  getallPersons(): Call<List<Person>>
}