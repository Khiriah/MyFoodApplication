package com.example.myfoodapplication.ui.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.example.myfoodapplication.Fragment.CartFragment
import com.example.myfoodapplication.Model.Food
import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.Model.Product
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.OrderViewModel
import com.example.myfoodapplication.ViewModel.ProductViewModel
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val viewModel: OrderViewModel by viewModels()

        var textViewDName = findViewById<TextView>(R.id.textViewDName)
        var textViewDPrice = findViewById<TextView>(R.id.textViewDPrice)
        var textViewDCategory = findViewById<TextView>(R.id.textViewCategory)
        var textViewDCreatedAt = findViewById<TextView>(R.id.textViewCreatedAt)
        var spinnerQuantity = findViewById<Spinner>(R.id.spinnerQuantity)
        var textviewDDescrepion = findViewById<TextView>(R.id.TextviewDDescrepion)
        var imageView = findViewById<ImageView>(R.id.imageViewD)
        var buttonDAdd = findViewById<Button>(R.id.btnDAdd)
        var calendar = Calendar.getInstance()
        var dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        var date = dateFormat.format(calendar.time)
        textViewDCreatedAt.text = date

        var item: Any = 0
        var QuantityList = arrayOf(1, 2, 3, 4, 5)
        spinnerQuantity.adapter =
            ArrayAdapter<Int>(this, android.R.layout.simple_spinner_item, QuantityList)
        spinnerQuantity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                item = parent!!.getItemAtPosition(position)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        val FoodDetail = intent.getSerializableExtra("Foods") as Food
        textViewDName.setText(FoodDetail.name)
        textViewDPrice.setText(FoodDetail.price)
        textviewDDescrepion.setText(FoodDetail.description)
        textViewDCategory.setText(FoodDetail.category)
        Picasso.get().load(FoodDetail.photo).into(imageView)


        var userId = SharedPrefHelper.getUserId(this)
//        var fId = FoodDetail.id
        buttonDAdd.setOnClickListener {
            println("clicked")
            var orderId = SharedPrefHelper.getOrderId(this)
            if (orderId != "null") {
                // TODO:1. create new order 2. add product 3. update total price

                // create new Order
                var order = Order(
                    "",
                    "",
                    0,
                    userId
                )
                viewModel.creatOrder(order.id, order.uesrId, order.total_price, order.order_date)
                    .observeForever {
                        if (it != null) {
                            Toast.makeText(this, "added", Toast.LENGTH_SHORT).show()
                            SharedPrefHelper.saveOrderId(this, it.id)
                            SharedPrefHelper.getOrderId(this)
                        } else {
                            Toast.makeText(this, "the order not added", Toast.LENGTH_SHORT).show()
                        }
                    }
                ///////////////end of create order////////////////////////////

                // Add product to cart
                val viewModel: ProductViewModel by viewModels()
                var product = Product(
                    textViewDCategory.text.toString(),
                    textViewDCreatedAt.text.toString(),
                    textviewDDescrepion.text.toString(),
                    "",
                    textViewDName.text.toString(),
                    orderId,
                    FoodDetail.photo,
                    textViewDPrice.text.toString(),
                    item as Int
                )
                var mutableLiveData = MutableLiveData<Product>()
                viewModel.addItemToProduct(
                    product.category,
                    product.createdAt,
                    product.description,
                    product.id,
                    product.name,
                    product.orderId,
                    product.photo,
                    product.price,
                    product.quantity
                ).observeForever {
                    if (it != null) {
                        mutableLiveData.postValue(it)
                    } else {
                        mutableLiveData.postValue(
                            Product(
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                0
                            )
                        )
                    }
                }

                /////////////// end of add product /////////////////////////////////


            } else {
                // TODO:1. add product 2. update total price for order
                val viewModel: ProductViewModel by viewModels()
                var product = Product(
                    textViewDCategory.text.toString(),
                    textViewDCreatedAt.text.toString(),
                    textviewDDescrepion.text.toString(),
                    "",
                    textViewDName.text.toString(),
                    orderId,
                    FoodDetail.photo,
                    textViewDPrice.text.toString(),
                    item as Int
                )
                var mutableLiveData = MutableLiveData<Product>()
                viewModel.addItemToProduct(
                    product.category,
                    product.createdAt,
                    product.description,
                    product.id,
                    product.name,
                    product.orderId,
                    product.photo,
                    product.price,
                    product.quantity

                ).observeForever {

                    if (it != null) {
                        mutableLiveData.postValue(it)
                    } else {
                        mutableLiveData.postValue(
                            Product(
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                0
                            )
                        )
                    }
                }

            }
        }
    }
}
