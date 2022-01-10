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

//
//            swipeContainer = v.findViewById(R.id.swipeContainer);
//        swipeContainer.setOnRefreshListener{
//                    // refresh your list contents somehow
//            swipeContainer.isRefreshing = false}
//
//        swipeContainer.setColorSchemeColors(android.R.color.holo_green_dark,
//            android.R.color.holo_red_dark,
//            android.R.color.holo_blue_dark,
//            android.R.color.holo_orange_dark);

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

//        println(totalPrice)
        orderButton.setOnClickListener {


            var orderId = SharedPrefHelper.getOrderId(context)
            var userId = SharedPrefHelper.getUserId(context)
            val viewModel: OrderViewModel by viewModels()
            viewModel.updatetotalPrice(
                Order(
                    orderId,
                    "",
//                    orderTotalTextView.text.toString(),
                    totalPrice.toString(),
                    userId
                ),userId).observeForever {
                Toast.makeText(context, "Ubdate", Toast.LENGTH_SHORT).show()
                var intent = Intent(context, OrderActivity::class.java)
                context.startActivity(intent)
            }
        }
        return v
    }
//
//    override fun onRefresh() {
//        TODO("Not yet implemented")
//    }


}

