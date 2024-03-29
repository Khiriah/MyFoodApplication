package com.example.myfoodapplication.Repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.myfoodapplication.Model.Food
import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.Model.User
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.network.API
import com.example.myfoodapplication.network.OrderService
import com.example.myfoodapplication.network.UserService
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class OrderRepository {


    val OrderService = API.getInstance().create(OrderService::class.java)

    var mutableTotalPrice = MutableLiveData<Double>()

    //   getallCart

//    fun getCartById(id:String): MutableLiveData<Food> {
//        val callCartList = CartService.getCartById(id)
//        callCartList.enqueue(object : Callback<Food> {
//            override fun onResponse(call: Call<Food>, response: Response<Food>) {
//                mutableLiveData.postValue(response.body())
//            }
//
//            override fun onFailure(call: Call<Food>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
//        return mutableLiveData
//    }
//}

//    fun getCartById(id: String): MutableLiveData<Food> {
//        val callCartList = CartService.getCartById(id)
//        callCartList.enqueue(object : Callback<Food> {
//            override fun onResponse(call: Call<Food>, response: Response<Food>) {
//                mutableLiveData.postValue(response.body())
//            }
//
//            override fun onFailure(call: Call<Food>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
//        return mutableLiveData
//    }

    var context: Context? = null



//    val user =userService.getUserByFbId(auth.currentUser?.uid.toString())


    fun creatOrder(
        uesrId: String,
        order_date:String,
        total_price:String
    ): MutableLiveData<Order> {
        var mutableLiveData = MutableLiveData<Order>()
//       var userId = context?.let { SharedPrefHelper.getUserId(it.applicationContext) }

        val callCartList =
            OrderService.creatOrder(uesrId, Order( "",order_date, total_price, uesrId))
        callCartList.enqueue(object : Callback<Order> {
            override fun onResponse(call: Call<Order>, response: Response<Order>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<Order>, t: Throwable) {
                println("Error")
            }
        })
        return mutableLiveData
    }
    fun updatetotalPrice( order: Order,
                    userId:String
    ): MutableLiveData<Order> {

        var mutableLiveData= MutableLiveData<Order>()


        val callCartList =
            OrderService.updatetotalPrice(userId,order)

        callCartList.enqueue(object : Callback<Order> {
            override fun onResponse(call: Call<Order>, response: Response<Order>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<Order>, t: Throwable) {

            }

        })


        return mutableLiveData
    }
}


//
//    fun removeItemFromCart(): MutableLiveData<Order> {
//        var mutableLiveData = MutableLiveData<Order>()
//        val callCartList = CartService.deleteCart()
//        callCartList.enqueue(object : Callback<Order> {
//            override fun onResponse(call: Call<Order>, response: Response<Order>) {
//                if (response.isSuccessful)
//                    println("successful")
//
//            }
//
//            override fun onFailure(call: Call<Order>, t: Throwable) {
//            }
//        })
//        return mutableLiveData
//    }
//}

//


//    fun getTotalPrice(): LiveData<Double?>? {
//        if (mutableTotalPrice.value == null) {
//            mutableTotalPrice.value = 0.0
//        }
//        return mutableTotalPrice
//    }

//
//
//
//}


//    fun getCart(): LiveData<List<Cart>?>? {
//        if (mutableLiveData.value == null) {
//            initCart()
//        }
//        return mutableLiveData
//    }
//
//    fun initCart() {
//        mutableLiveData.setValue(ArrayList<Cart>())
//        calculateCartTotal()
//    }

//    fun addItemToCart(food: Food): Boolean {
//        if (mutableLiveData.value == null) {
//            initCart()
//        }
//        val cartItemList: MutableList<Cart> = ArrayList<Any?>(mutableLiveData.value)
//        for (Cart in cartItemList) {
//            if (Cart.getallCarts().getId().equals(food.getId())) {
//                if (Cart.getQuantity() === 5) {
//                    return false
//                }
//                val index = cartItemList.indexOf(cartItem)
//                cartItem.setQuantity(cartItem.getQuantity() + 1)
//                cartItemList[index] = cartItem
//                mutableLiveData.setValue(cartItemList)
//                calculateCartTotal()
//                return true
//            }
//        }
//        val cartItem = Cart(Food, 1)
//        cartItemList.add(cartItem)
//        mutableLiveData.setValue(cartItemList)
//        calculateCartTotal()
//        return true
//    }
//
//    fun removeItemFromCart(cartItem: Cart) {
//        if (mutableLiveData.value == null) {
//            return
//        }
//        val cartItemList: MutableList<Cart> = ArrayList<Any?>(mutableLiveData.value)
//        cartItemList.remove(cartItem)
//        mutableLiveData.setValue(cartItemList)
//        calculateCartTotal()
//    }
//
//    fun changeQuantity(cartItem: Cart, quantity: Int) {
//        if (mutableLiveData.value == null) return
//        val cartItemList: MutableList<Cart> = ArrayList<Any?>(mutableLiveData.value)
//        val updatedItem = Cart(cartItem.getFood(), quantity)
//        cartItemList[cartItemList.indexOf(cartItem)] = updatedItem
//        mutableLiveData.setValue(cartItemList)
//        calculateCartTotal()
//    }
//

//

