package com.example.myfoodapplication.network

import com.google.firebase.firestore.auth.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("User")
    fun getUserByUsernameAndPassword(@Query("username")username:String, @Query("password")password:String): Call<List<User>>
}