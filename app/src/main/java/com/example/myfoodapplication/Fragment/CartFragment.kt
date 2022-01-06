package com.example.myfoodapplication.Fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.myfoodapplication.Model.Product
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.ProductViewModel
import com.example.myfoodapplication.adapter.ProductAdapter



class CartFragment : Fragment() {

    lateinit var swipeContainer: SwipeRefreshLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = inflater.context
        var v = inflater.inflate(R.layout.fragment_cart, container, false)
        var cartRecyclerView = v.findViewById<RecyclerView>(R.id.cartRecyclerView)
//        swipeContainer = v.findViewById(R.id.swipeContainer)
//        // Setup refresh listener which triggers new data loading
//
//        swipeContainer.setOnRefreshListener {
//            // Your code to refresh the list here.
//            // Make sure you call swipeContainer.setRefreshing(false)
//            // once the network request has completed successfully.
//            fetchTimelineAsync(0)
//        }
//        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
//            android.R.color.holo_green_light,
//            android.R.color.holo_orange_light,
//            android.R.color.holo_red_light);

        val viewModel: ProductViewModel by viewModels()
        var userid=SharedPrefHelper.getUserId(context)
        var orderId=SharedPrefHelper.getOrderId(context)
       viewModel.getProductById(userid, orderId).observe(viewLifecycleOwner, {
           if (it!=null)
           cartRecyclerView.adapter = ProductAdapter(it as MutableList<Product>)

       })
        return v
    }

}

