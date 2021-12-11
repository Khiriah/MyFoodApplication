package com.example.myfoodapplication.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ViewModel.CartViewModel
import com.example.myfoodapplication.ViewModel.PersonViewModel
import com.example.myfoodapplication.adapter.CartAdapter
import com.example.myfoodapplication.adapter.PersonAdapter


class CartFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var v = inflater.inflate(R.layout.fragment_cart, container, false)
        var cRecyclerView = v.findViewById<RecyclerView>(R.id.cRecyclerView)
        val viewModel: CartViewModel by viewModels()
        cRecyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.getCarts().observe(this, { list ->
            cRecyclerView.adapter = CartAdapter(list)

        })
       return v
   }
    }

