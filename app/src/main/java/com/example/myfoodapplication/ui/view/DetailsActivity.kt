package com.example.myfoodapplication.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
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


        /****************************back***************************/
        var imageViewDetail = findViewById<ImageView>(R.id.imageViewDetail)
        imageViewDetail.setOnClickListener {
            finish()
        }
        /****************************back***************************/


        /****************************get from Intent***************************/
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
        /****************************end of get Intent***************************/


        /****************************CreatedAT***************************/
        var textViewDCreatedAt = findViewById<TextView>(R.id.textViewCreatedAt)
        var calendar = Calendar.getInstance()
        var dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        var date = dateFormat.format(calendar.time)
        textViewDCreatedAt.text = date
        /****************************end of CreatedAT***************************/


        /****************************Quantity***************************/
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
        /****************************End of Quantity***************************/


        /****************************Button add to cart ***************************/
        var buttonDAdd = findViewById<TextView>(R.id.btnDAdd)
        buttonDAdd.setOnClickListener {
            var userId = SharedPrefHelper.getUserId(this)
            var orderid = SharedPrefHelper.getOrderId(this)
            val productViewModel: ProductViewModel by viewModels()
            if (orderid == "null") {

                // create order
                val viewModel: OrderViewModel by viewModels()
                var order = Order("", date, "", userId)
                viewModel.creatOrder(order.uesrId, "", order.order_date)
                    .observeForever {
                        if (it != null) {
                            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
                            SharedPrefHelper.saveOrderId(this, it.id)

                        } else {
                            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()

                        }
                    }

                //add product
                var product = Product(
                    foodDetail.category,
                    date,
                    foodDetail.description,
                    "",
                    foodDetail.name,
                    SharedPrefHelper.getOrderId(this),
                    foodDetail.photo,
                    (foodDetail.price.toDouble() * spinnerQuantity.selectedItem.toString()
                        .toDouble()).toString(),
                    item as Int
                )
                productViewModel.addItemToProduct(product, userId).observeForever {
                    if (it != null)
                        Toast.makeText(this, "added", Toast.LENGTH_SHORT).show()
                    else
                        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                }

            } else {
                var product = Product(
                    foodDetail.category,
                    date,
                    foodDetail.description,
                    "",
                    foodDetail.name,
                    SharedPrefHelper.getOrderId(this),
                    foodDetail.photo,
                    (foodDetail.price.toDouble() * spinnerQuantity.selectedItem.toString()
                        .toDouble()).toString(),
                    item as Int
                )
                productViewModel.addItemToProduct(product, userId).observeForever {
                    if (it != null)
                        Toast.makeText(this, "added", Toast.LENGTH_SHORT).show()
                    else
                        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                }


            }
        }
        /****************************end of the button add ***************************/
    }
}

