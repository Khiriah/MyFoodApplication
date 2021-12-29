package com.example.myfoodapplication.Fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.ProductViewModel
import com.example.myfoodapplication.adapter.ProductAdapter



class CartFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = inflater.context
        var v = inflater.inflate(R.layout.fragment_cart, container, false)
        var cartRecyclerView = v.findViewById<RecyclerView>(R.id.cartRecyclerView)
        val viewModel: ProductViewModel by viewModels()
        var userid=SharedPrefHelper.getUserId(context)
        var orderId=SharedPrefHelper.getOrderId(context)
       viewModel.getProductById(userid, orderId).observe(this, { list ->
           cartRecyclerView.adapter = ProductAdapter(list)
       })
        return v
    }
}

