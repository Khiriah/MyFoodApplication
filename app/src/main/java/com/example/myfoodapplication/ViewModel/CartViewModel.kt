package com.example.myfoodapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myfoodapplication.Model.Cart
import com.example.myfoodapplication.Model.Food
import com.example.myfoodapplication.Repository.CartRepository
import com.example.myfoodapplication.Repository.FoodRepository

class CartViewModel  : ViewModel() {


    var CartRepository= CartRepository()

    fun getCarts(): LiveData<List<Cart>> {
        return CartRepository.getallCarts()
    }
}