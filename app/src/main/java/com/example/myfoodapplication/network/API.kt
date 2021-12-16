package com.example.myfoodapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {

    companion object{
        private  val retrofit: Retrofit
        init {
            retrofit = Retrofit.Builder()
                .baseUrl("https://61b877c164e4a10017d18fc2.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getInstance(): Retrofit {
            return retrofit
        }
    }

}