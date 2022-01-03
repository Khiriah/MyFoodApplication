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
       product: Product,
       userid: String
    ): MutableLiveData<Product> {
        var mutableLiveData = MutableLiveData<Product>()
        productRepo.addItemToProduct(product,userid)
            .observeForever {
                  mutableLiveData.postValue(it)
            }
        return mutableLiveData
    }

    fun deletefromCart(
        userid: String,
        orderId: String

    ): MutableLiveData<Product> {
        var mutableLiveData = MutableLiveData<Product>()
        productRepo.deletefromCart(orderId,userid)
            .observeForever {
                mutableLiveData.postValue(it)
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