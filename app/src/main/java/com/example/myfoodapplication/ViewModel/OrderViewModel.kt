package com.example.myfoodapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.myfoodapplication.Repository.OrderRepository

class OrderViewModel  : ViewModel() {
    var orderRepo = OrderRepository()









////    fun getallCart(): LiveData<Food> {
////        return cartRepo.getallCart()
////    }
//    fun getCartById(id:String): LiveData<Food> {
//    var mutableLiveData = MutableLiveData<Food>()
//    CartRepository().getCartById(id)
//        .observeForever {
//
//        }
//
//        return mutableLiveData
//    }
//
    fun addItemToOrder(
    id: String,
    uesrId: String,
    total_price: Int,
    order_date: String
): LiveData<Boolean> {
        var mutableLiveData = MutableLiveData<Boolean>()
    orderRepo.addItemToOrder(id,uesrId,total_price,order_date)
            .observeForever {
              if (it.id.isNotEmpty()) {
                    mutableLiveData.postValue(true)
               } else {
                    mutableLiveData.postValue(false)
                }
            }
        return mutableLiveData
    }

//    fun removeItemFromCart(): LiveData<Cart> {
//        var mutableLiveData = MutableLiveData<Cart>()
//        CartRepository().removeItemFromCart()
//            .observeForever {
//
//            }
//        return mutableLiveData
//    }
//
//    fun changeQuantity(cart: Cart, quantity: Int) {
//        var mutableLiveData = MutableLiveData<Cart>()
//        CartRepository().removeItemFromCart()
//            .observeForever {
//
//            }
//        return mutableLiveData
//    }

//    fun getTotalPrice(): LiveData<Double?>? {
//        return cartRepo.getTotalPrice()
//    }
//    fun calculateCartTotal(): LiveData<Double>{
//        return cartRepo.calculateCartTotal()
//    }
}



