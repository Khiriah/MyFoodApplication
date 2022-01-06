package com.example.myfoodapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.Model.User

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
    fun creatOrder(
    uesrId: String,
    total_price: String,
    order_date: String
): LiveData<Order> {
        var mutableLiveData = MutableLiveData<Order>()
    orderRepo.creatOrder(uesrId,order_date,total_price)
            .observeForever {
              if (it.id.isNotEmpty()) {
                    mutableLiveData.postValue(it)
               } else {
                    mutableLiveData.postValue(it)
                }
            }
        return mutableLiveData
    }
    fun updatetotalPrice(
    order: Order,
    userId:String

    ):LiveData<Order> {
        return orderRepo.updatetotalPrice(order,userId)


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



