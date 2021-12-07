package com.example.myfoodapplication.network

import retrofit2.http.GET

interface PersonService {
    @GET("Persons")
    fun  getallPersons()
}