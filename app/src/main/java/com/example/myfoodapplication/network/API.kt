package com.example.myfoodapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {

    companion object{
        private  val retrofit: Retrofit
        init {
            retrofit = Retrofit.Builder()
                .baseUrl("https://mockapi.io/projects/619dfb4c131c60001708923a")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getInstance(): Retrofit {
            return retrofit
        }
    }

}