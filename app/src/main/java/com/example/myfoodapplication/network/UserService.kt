package com.example.myfoodapplication.network

import retrofit2.http.GET

interface UserService {
    @GET("Users")
    fun getUsers()
}