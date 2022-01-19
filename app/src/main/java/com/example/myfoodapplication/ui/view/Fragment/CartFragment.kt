package com.example.myfoodapplication.ui.view.Fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.Model.Product
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.OrderViewModel
import com.example.myfoodapplication.ViewModel.ProductViewModel
import com.example.myfoodapplication.adapter.ProductAdapter
import com.example.myfoodapplication.ui.view.OrderActivity
import java.text.SimpleDateFormat
import java.util.*


//<androidx.swiperefreshlayout.widget.SwipeRefreshLayout
//xmlns:android="http://schemas.android.com/apk/res/android"
//android:id="@+id/swipeContainer"
//android:layout_width="match_parent"
//android:layout_height="match_parent">


//</androidx.swiperefreshlayout.widget.SwipeRefreshLayout>
//, SwipeRefreshLayout.OnRefreshListener
class CartFragment : Fragment() {
    //    lateinit var swipeContainer: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = inflater.context
        var v = inflater.inflate(R.layout.fragment_cart, container, false)
        var cartRecyclerView = v.findViewById<RecyclerView>(R.id.cartRecyclerView)
        var orderButton = v.findViewById<Button>(R.id.OrderButton)
        var totalPrice: Double = 0.0
        var orderTotalTextView = v.findViewById<TextView>(R.id.orderTotalTextView)



        /****************************CreatedAT***************************/
        var textViewOCreatedAt=v.findViewById<TextView>(R.id.textViewOCreatedAt)
        var calendar = Calendar.getInstance()
        var dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        var date = dateFormat.format(calendar.time)
        textViewOCreatedAt.text = date
        /****************************end of CreatedAT***************************/

        val viewModel: ProductViewModel by viewModels()
        var userid = SharedPrefHelper.getUserId(context)
        var orderId = SharedPrefHelper.getOrderId(context)
        viewModel.getProductById(userid, orderId).observe(viewLifecycleOwner, {
            if (it != null) {
                cartRecyclerView.adapter = ProductAdapter(it as MutableList<Product>)
                for (i in it) {
                    totalPrice += i.price.toDouble()

                }
                orderTotalTextView.text = totalPrice.toString()
            }

        })


        orderButton.setOnClickListener {


            var orderId = SharedPrefHelper.getOrderId(context)
            var userId = SharedPrefHelper.getUserId(context)
            val viewModel: OrderViewModel by viewModels()
            var order=Order(
                orderId,
                date,
//                    orderTotalTextView.text.toString(),
                totalPrice.toString(),
                userId
            )
            viewModel.updatetotalPrice(order,userId).observeForever {
                SharedPrefHelper.clearOrderId(context)
                Toast.makeText(context, "Ubdate", Toast.LENGTH_SHORT).show()
                var intent = Intent(context, OrderActivity::class.java)
                context.startActivity(intent)
            }
        }
        return v
    }



}

