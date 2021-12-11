package com.example.myfoodapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myfoodapplication.Model.Food

import com.example.myfoodapplication.Repository.FoodRepository


class FoodViewModel : ViewModel() {


    var foodRepository= FoodRepository()

    fun getFoods(): LiveData<List<Food>> {
        return foodRepository.getallFoods()
    }
}