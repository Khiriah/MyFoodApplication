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
import com.google.common.collect.Iterables.size
import com.google.common.collect.Iterators.size
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        ///////////////get from Intent ////////////////////////////
        var textViewDName = findViewById<TextView>(R.id.textViewDName)
        var textViewDPrice = findViewById<TextView>(R.id.textViewDPrice)
        var textViewDCategory = findViewById<TextView>(R.id.textViewCategory)
        var textviewDDescrepion = findViewById<TextView>(R.id.TextviewDDescrepion)
        var imageViewD = findViewById<ImageView>(R.id.imageViewD)
        val foodDetail = intent.getSerializableExtra("Foods") as Food
        textViewDName.setText(foodDetail.name)
        textViewDPrice.setText(foodDetail.price)
        textviewDDescrepion.setText(foodDetail.description)
        textViewDCategory.setText(foodDetail.category)
        Picasso.get().load(foodDetail.photo).into(imageViewD)
        ///////////////end of get Intent ////////////////////////////


        ///////////////CreatedAT////////////////////////////
        var textViewDCreatedAt = findViewById<TextView>(R.id.textViewCreatedAt)
        var calendar = Calendar.getInstance()
        var dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        var date = dateFormat.format(calendar.time)
        textViewDCreatedAt.text = date
        ///////////////end of CreatedAT ////////////////////////////


        /////////////// Quantity ////////////////////////////
        var spinnerQuantity = findViewById<Spinner>(R.id.spinnerQuantity)
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
        ///////////////end of Quantity ////////////////////////////


//        var textViewDCreatedAt=findViewById<TextView>(R.id.textViewDCreatedAt)
        var userId = SharedPrefHelper.getUserId(this)
        var orderid = SharedPrefHelper.getOrderId(this)
        if (orderid.isEmpty()) {
            val viewModel: OrderViewModel by viewModels()
            var calendar = Calendar.getInstance()
            var dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            var date = dateFormat.format(calendar.time)
            textViewDCreatedAt.text = date

            var order = Order("", date, "", userId)

            viewModel.creatOrder(order.uesrId, "", order.order_date)
                .observeForever {
                    if (it != null) {
                        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
                        SharedPrefHelper.saveOrderId(this, it.id)

                    } else {
                        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()

                    }
                }
        }
        ///////////////button add to cart  ////////////////////////////
        var buttonDAdd = findViewById<Button>(R.id.btnDAdd)
        buttonDAdd.setOnClickListener {
            var userId = SharedPrefHelper.getUserId(this)
            var orderid = SharedPrefHelper.getOrderId(this)
            val productViewModel: ProductViewModel by viewModels()
            if (orderid.isNotEmpty()) {
                var product = Product(
                    foodDetail.category,
                    date,
                    foodDetail.description,
                    "",
                    foodDetail.name,
                    orderid,
                    foodDetail.photo,
                    (foodDetail.price.toDouble() * spinnerQuantity.selectedItem.toString()
                        .toDouble()).toString(),
                    item as Int
                )

                productViewModel.addItemToProduct(product, userId).observeForever {
                    if (it != null) {
                        Toast.makeText(this, "added", Toast.LENGTH_SHORT).show()
//                        SharedPrefHelper.saveOrderId(this, it.id)

                    } else {
                        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()

                    }
                }
            }
            ///////////////end of the button add ////////////////////////////


        }
    }
}


//        var fId = FoodDetail.id
//        buttonDAdd.setOnClickListener {
//            println("clicked")
//            var orderId = SharedPrefHelper.getOrderId(this)
//            if (orderId == "") {
//                // TODO:1. create new order 2. add product 3. update total price
//
//                // create new Order
//                var order = Order(
//                    "",
//                    date,
//                    "0",
//                    userId
//                )
//                viewModel.creatOrder( order.uesrId, order.total_price,order.order_date)
//                    .observeForever {
//                        if (it != null) {
//                            Toast.makeText(this, "added", Toast.LENGTH_SHORT).show()
//                            SharedPrefHelper.saveOrderId(this, it.id)
////                            SharedPrefHelper.getOrderId(this)
//                        } else {
//                            Toast.makeText(this, "the order not added", Toast.LENGTH_SHORT).show()
//                        }
//                    }
//                ///////////////end of create order////////////////////////////
//
//                // Add product to cart
//                val viewModel: ProductViewModel by viewModels()
//                var product = Product(
//                    textViewDCategory.text.toString(),
//                    textViewDCreatedAt.text.toString(),
//                    textviewDDescrepion.text.toString(),
//                    "",
//                    textViewDName.text.toString(),
//                    orderId,
//                    FoodDetail.photo,
//                    textViewDPrice.text.toString(),
//                    item as Int
//                )
//                var mutableLiveData = MutableLiveData<Product>()
//                viewModel.addItemToProduct(
//                    product.category,
//                    product.createdAt,
//                    product.description,
//                    product.id,
//                    product.name,
//                    product.orderId,
//                    product.photo,
//                    product.price,
//                    product.quantity
//                ).observeForever {
//                    if (it != null) {
//                        mutableLiveData.postValue(it)
//                    } else {
//                        mutableLiveData.postValue(
//                            Product(
//                                "",
//                                "",
//                                "",
//                                "",
//                                "",
//                                "",
//                                "",
//                                "",
//                                0
//                            )
//                        )
//                    }
//                }
//
//                /////////////// end of add product /////////////////////////////////
//
//
//            } else {
//                // TODO:1. add product 2. update total price for order
//                val viewModel: ProductViewModel by viewModels()
//                var product = Product(
//                    textViewDCategory.text.toString(),
//                    textViewDCreatedAt.text.toString(),
//                    textviewDDescrepion.text.toString(),
//                    "",
//                    textViewDName.text.toString(),
//                    orderId,
//                    FoodDetail.photo,
//                    textViewDPrice.text.toString(),
//                    item as Int
//                )
//                var mutableLiveData = MutableLiveData<Product>()
//                viewModel.addItemToProduct(
//                    product.category,
//                    product.createdAt,
//                    product.description,
//                    product.id,
//                    product.name,
//                    product.orderId,
//                    product.photo,
//                    product.price,
//                    product.quantity
//
//                ).observeForever {
//
//                    if (it != null) {
//                        mutableLiveData.postValue(it)
//                    } else {
//                        mutableLiveData.postValue(
//                            Product(
//                                "",
//                                "",
//                                "",
//                                "",
//                                "",
//                                "",
//                                "",
//                                "",
//                                0
//                            )
//                        )
//                    }
//                }
//
//            }
////        }
//    }
//}
