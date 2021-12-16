package com.example.myfoodapplication.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myfoodapplication.Model.Food
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ViewModel.OrderViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
//        val viewModel: OrderViewModel by viewModels()

        var textViewDName = findViewById<TextView>(R.id.textViewDName)
        var textViewDPrice = findViewById<TextView>(R.id.textViewDPrice)
        var textviewDDescrepion = findViewById<TextView>(R.id.TextviewDDescrepion)
        var imageView = findViewById<ImageView>(R.id.imageViewD)
        var buttonDAdd = findViewById<Button>(R.id.btnDAdd)

//        var auth = Firebase.auth

        val FoodDetail = intent.getSerializableExtra("Foods") as Food
        textViewDName.setText(FoodDetail.name)
        textViewDPrice.setText(FoodDetail.price)
        textviewDDescrepion.setText(FoodDetail.description)
        Picasso.get().load(FoodDetail.photo).into(imageView)
//        var fId = FoodDetail.id
        buttonDAdd.setOnClickListener {
//            var uId = auth.currentUser?.uid
//            if (uId != null) {
//                viewModel.addItemToCart(fId, uId).observeForever {
//                    if (it) {
//                        Toast.makeText(this, "added", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }


        }
    }
}