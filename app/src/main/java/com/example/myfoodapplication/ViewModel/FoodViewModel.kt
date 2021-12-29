package com.example.myfoodapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfoodapplication.Model.Food
import com.example.myfoodapplication.Model.Product

import com.example.myfoodapplication.Repository.FoodRepository


class FoodViewModel : ViewModel() {


    var foodRepo= FoodRepository()
    fun getFoods(
        supplierId: String
    ): MutableLiveData<List<Food>> {
        var mutableLiveData = MutableLiveData<List<Food>>()
        foodRepo.getMenueById(supplierId)
            .observeForever {
             mutableLiveData.postValue(it)

            }
        return mutableLiveData
    }
//    fun getFoods(): LiveData<List<Food>> {
//        return foodRepo.getMenueById("1")

    }

