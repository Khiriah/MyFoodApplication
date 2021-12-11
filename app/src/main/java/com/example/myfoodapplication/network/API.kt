package com.example.myfoodapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {

    companion object{
        private  val retrofit: Retrofit
        init {
            retrofit = Retrofit.Builder()
                .baseUrl("https://619dfb4c131c600017089239.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getInstance(): Retrofit {
            return retrofit
        }
    }

}