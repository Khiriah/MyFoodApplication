package com.example.myfoodapplication.Repository

import androidx.lifecycle.MutableLiveData
import com.example.myfoodapplication.Model.Food
import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.Model.Product
import com.example.myfoodapplication.network.API
import com.example.myfoodapplication.network.FoodService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodRepository {

    val FoodService= API.getInstance().create(FoodService::class.java)

    fun getMenueById(id:String): MutableLiveData<List<Food>> {

        var mutableLiveData= MutableLiveData<List<Food>>()


        val callFoodList=FoodService.getMenueById(id)
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

//    fun addItemToProduct(
//        id: String,
//        category: String,
//       createdAt: String,
//       description: String,
//        name: String,
//        orderId: String,
//        photo: String,
//       price: String,
//       quantity: Int
//    ): MutableLiveData<Order> {
//        var mutableLiveData = MutableLiveData<Product>()
//        val callCartList = FoodService.addItemToProduct(Product(id, category, createdAt,
//            description,name,orderId,photo,price,quantity))
//        callCartList.enqueue(object : Callback<Product> {
//            override fun onResponse(call: Call<Product>, response: Response<Product>) {
//                mutableLiveData.postValue(response.body())
//            }
//
//            override fun onFailure(call: Call<Product>, t: Throwable) {
//                println("Error")
//            }
//        })
//        return mutableLiveData
//    }
}
