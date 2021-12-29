package com.example.myfoodapplication.Repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.Model.Product
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.network.API
import com.example.myfoodapplication.network.ProductService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {

    val productService = API.getInstance().create(ProductService::class.java)

    fun getProductById(
        userid: String,
        orderId: String

    ): MutableLiveData<List<Product>> {
        var mutableLiveData = MutableLiveData<List<Product>>()
//       var userId = context?.let { SharedPrefHelper.getUserId(it.applicationContext) }

        val callCartList =
            productService.getProductById(userid,orderId)
        callCartList.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                println("Error")
            }
        })
        return mutableLiveData
    }




    fun addItemToProduct(
         category: String,
         createdAt: String,
         description: String,
         id: String,
         name: String,
         orderId: String,
         photo: String,
         price: String,
         quantity: Int
    ): MutableLiveData<Product> {
        var mutableLiveData = MutableLiveData<Product>()
//       var userId = context?.let { SharedPrefHelper.getUserId(it.applicationContext) }


        fun getall(context: Context){
        var  userId=   SharedPrefHelper.getUserId(context )


        val callCartList =
            productService.addItemToProduct(userId ,orderId, Product(category,createdAt,description,id,name,orderId,photo,price,quantity))
        callCartList.enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                println("Error")
            }
        })}
        return mutableLiveData
    }

}

