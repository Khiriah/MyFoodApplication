package com.example.myfoodapplication.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.OrderViewModel
import com.example.myfoodapplication.login.LoginActivity
import com.example.myfoodapplication.ui.view.HomeActivity
import com.google.firebase.messaging.FirebaseMessaging
import java.text.SimpleDateFormat
import java.util.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
//        FirebaseMessaging.getInstance().token.addOnCompleteListener {
//            var token = it.result.toString()
//            println(token)
        var textViewDCreatedAt=findViewById<TextView>(R.id.textViewDCreatedAt)
        var userId = SharedPrefHelper.getUserId(this)
        var orderid = SharedPrefHelper.getOrderId(this)
        if(orderid.isEmpty()) {
            val viewModel: OrderViewModel by viewModels()
            var calendar = Calendar.getInstance()
            var dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            var date = dateFormat.format(calendar.time)
            textViewDCreatedAt.text = date
            var order = Order("", date, "0", userId)

            viewModel.creatOrder(order.uesrId, order.total_price, order.order_date)
                .observeForever {
                    if (it != null) {
                        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
                        SharedPrefHelper.saveOrderId(this, it.id)

                    } else {
                      Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()

                    }
                }
        }


            Handler().postDelayed({
                if(SharedPrefHelper.getUserId(this)=="null"){
                    var intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)

                }else{
                    var intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }

                finish()
            }, 5000)
        }
    }
