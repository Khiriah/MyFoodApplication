package com.example.myfoodapplication.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ViewModel.OrderViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class CartFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_cart, container, false)
        var cRecyclerView = v.findViewById<RecyclerView>(R.id.cartRecyclerView)

//        var auth = Firebase.auth
//        var uId = auth.currentUser?.uid
//        val viewModel: OrderViewModel by viewModels()
//        viewModel.getCartById(uId.toString()).observe(his, { list ->
//            cRecyclerView.adapter = OrderAdapter(list)
//        })
        return v
    }
}

