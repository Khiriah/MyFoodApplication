package com.example.myfoodapplication.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.Model.Food
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ViewModel.FoodViewModel
import com.example.myfoodapplication.adapter.FoodAdapter


class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val viewModel: FoodViewModel by viewModels()
        var fRecyclerView=findViewById<RecyclerView>(R.id.fRecyclerView)
        fRecyclerView.layoutManager= LinearLayoutManager(this)


        viewModel.getFoods().observe(this,{list->
            fRecyclerView.adapter= FoodAdapter(list)
        })

    }
}