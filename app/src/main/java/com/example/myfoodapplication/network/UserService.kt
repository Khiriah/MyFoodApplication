package com.example.myfoodapplication.network


import com.example.myfoodapplication.Model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {

    @GET("uesrs")
    fun getUserByFbId(@Query("fb_id")fbId:String): Call<List<User>>
    @POST("uesrs")
    fun addUser(@Body user: User): Call<User>
}