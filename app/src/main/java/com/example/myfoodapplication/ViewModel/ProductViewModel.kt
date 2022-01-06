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
        pId: String,
        userId: String,
        orderId: String

    ): MutableLiveData<Product> {
        var mutableLiveData = MutableLiveData<Product>()
        productRepo.deletefromCart(userId,orderId,pId)
            .observeForever {
                mutableLiveData.postValue(it)
            }
        return mutableLiveData
    }
    fun getProductById(
        userid: String,
        orderId: String
    ): LiveData<List<Product>> {

        return productRepo.getProductById(userid,orderId)
    }
}