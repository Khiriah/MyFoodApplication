package com.example.myfoodapplication.ui.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.myfoodapplication.Model.Food
import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.Model.Product
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.OrderViewModel
import com.example.myfoodapplication.ViewModel.ProductViewModel
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val viewModel: OrderViewModel by viewModels()

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


        var userId = SharedPrefHelper.getUserId(this)
        var fId = FoodDetail.id
        buttonDAdd.setOnClickListener {
            var order = Order(
                "",
                "",
                0,
                userId
            )
            if (fId != null) {
                viewModel.creatOrder(order.id, order.uesrId, order.total_price, order.order_date)
                    .observeForever {
                        if (it != null) {
                            Toast.makeText(this, "added", Toast.LENGTH_SHORT).show()
                            SharedPrefHelper.saveOrderId(this, it.id)
                            SharedPrefHelper.getOrderId(this)
                        }
                    }
            }
            val viewModel: ProductViewModel by viewModels()

            var orderId = SharedPrefHelper.getOrderId(this)
            if (orderId != null) {
                viewModel.addItemToProduct(
                    FoodDetail.category,
                    FoodDetail.cre
                    FoodDetail.name,
                    FoodDetail.photo,
                    FoodDetail.price,

                ).observeForever {
                    if (it) {
                        Toast.makeText(this, "added", Toast.LENGTH_SHORT).show()
                    }
                }
            }


        }
    }
}