package com.example.myfoodapplication.Repository

import androidx.lifecycle.MutableLiveData
import com.example.myfoodapplication.Model.Food
import com.example.myfoodapplication.Model.Person
import com.example.myfoodapplication.network.API
import com.example.myfoodapplication.network.FoodService
import com.example.myfoodapplication.network.PersonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodRepository {
    fun getallFoods(): MutableLiveData<List<Food>> {

        var mutableLiveData= MutableLiveData<List<Food>>()

        val FoodService= API.getInstance().create(FoodService::class.java)
        val callFoodList=FoodService.getallFoods()
        callFoodList.enqueue(object : Callback<List<Food>> {
            override fun onResponse(call: Call<List<Food>>, response: Response<List<Food>>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Food>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return mutableLiveData
    }
}