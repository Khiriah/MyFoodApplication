package com.example.myfoodapplication.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ViewModel.SupplierViewModel
import com.example.myfoodapplication.adapter.SupplierAdapter


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_home, container, false)
        var pRecyclerView = v.findViewById<RecyclerView>(R.id.recyclerViewP)
//      var pSearchView = v.findViewById<SearchView>(R.id.searchViewP)
//        var textViewLoction = v.findViewById<TextView>(R.id.textViewLoction)
        val viewModel: SupplierViewModel by viewModels()
        pRecyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.getSupplier().observe(this, { list ->
            pRecyclerView.adapter = SupplierAdapter(list)

        })
        return v
    }

}
