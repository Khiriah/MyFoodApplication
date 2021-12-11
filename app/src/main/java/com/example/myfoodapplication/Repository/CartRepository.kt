package com.example.myfoodapplication.Repository

import androidx.lifecycle.MutableLiveData
import com.example.myfoodapplication.Model.Cart
import com.example.myfoodapplication.network.API
import com.example.myfoodapplication.network.CartService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartRepository {
    fun getallCarts(): MutableLiveData<List<Cart>> {

        var mutableLiveData= MutableLiveData<List<Cart>>()

        val CartService= API.getInstance().create(CartService::class.java)
        val callCartList=CartService.getallCarts()
        callCartList.enqueue(object : Callback<List<Cart>> {
            override fun onResponse(call: Call<List<Cart>>, response: Response<List<Cart>>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Cart>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return mutableLiveData
    }
}