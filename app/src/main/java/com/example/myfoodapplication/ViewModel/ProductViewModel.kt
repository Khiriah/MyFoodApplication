package com.example.myfoodapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfoodapplication.Model.Product
import com.example.myfoodapplication.Repository.OrderRepository
import com.example.myfoodapplication.Repository.ProductRepository

class ProductViewModel : ViewModel() {
    var productRepo = ProductRepository()

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
        productRepo.addItemToProduct(category,createdAt,description,id,name,orderId,photo,price,quantity)
            .observeForever {
//                if (it.id.isNotEmpty()) {
                  mutableLiveData.postValue(it)
//                } else {
//                    mutableLiveData.postValue(false)
//                }
            }
        return mutableLiveData
    }
    fun getProductById(
        userid: String,
        orderId: String
    ): MutableLiveData<List<Product>> {
        var mutableLiveData = MutableLiveData<List<Product>>()
        productRepo.getProductById(userid,orderId)
            .observeForever {
                mutableLiveData.postValue(it)
            }
        return mutableLiveData
    }
}