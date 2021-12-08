package com.example.myfoodapplication.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.myfoodapplication.R
import com.example.myfoodapplication.viewModel.Food
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        var textViewDName = findViewById<TextView>(R.id.textViewDName)
        var textViewDPrice = findViewById<TextView>(R.id.textViewDPrice)
        var textviewDDescrepion = findViewById<TextView>(R.id.TextviewDDescrepion)
        var imageView=findViewById<ImageView>(R.id.imageViewD)
        var buttonDAdd = findViewById<Button>(R.id.btnDAdd)



        val FoodDetail = intent.getSerializableExtra("Foods") as Food
        textViewDName.setText(FoodDetail.FoodName)
        textViewDPrice.setText(FoodDetail.FoodPrice)
        textviewDDescrepion.setText(FoodDetail.FoodDescription)
        Picasso.get().load(FoodDetail.FoodImage).into(imageView)

        buttonDAdd.setOnClickListener {

            var intent = Intent(this, CartFragment::class.java)
         //  intent.putExtra()
            startActivity(intent)

        }
    }
}