package com.example.myfoodapplication.network


import com.example.myfoodapplication.Model.User
import retrofit2.Call
import retrofit2.http.*

interface UserService {

    @GET("uesrs")
    fun getUserByFbId(@Query("fb_id")fbId:String): Call<List<User>>
    @GET("uesrs/{id}")
    fun getUserById(@Path("id")id:String): Call<User>
    @POST("uesrs")
    fun addUser(@Body user: User): Call<User>
    @PUT("uesrs/{id}")
    fun updateUser(@Path("id")id:String,@Body user: User): Call<User>
}