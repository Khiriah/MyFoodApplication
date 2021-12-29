package com.example.myfoodapplication.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.Model.Food
import com.example.myfoodapplication.Model.Supplier
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.FoodViewModel
import com.example.myfoodapplication.adapter.FoodAdapter
import com.squareup.picasso.Picasso


class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val viewModel: FoodViewModel by viewModels()




        var textViewSName = findViewById<TextView>(R.id.textViewSName)
        var textViewSRating = findViewById<TextView>(R.id.textViewSRating)
       var imageView=findViewById<ImageView>(R.id.imageViewS)
        var supplier = intent.getSerializableExtra("supplier") as Supplier
        textViewSName.setText(supplier.name)
        textViewSRating.setText(supplier.rating)
        Picasso.get().load(supplier.logo).into(imageView)


        var fRecyclerView=findViewById<RecyclerView>(R.id.fRecyclerView)
        fRecyclerView.layoutManager= GridLayoutManager(this,2)
        viewModel.getFoods(supplier.id).observe(this,{list->
            fRecyclerView.adapter= FoodAdapter(list)
//
        })

    }
}