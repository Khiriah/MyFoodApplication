package com.example.myfoodapplication.Fragment

import android.app.Person
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.R
import com.example.myfoodapplication.adapter.PersonAdapter


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v=inflater.inflate(R.layout.fragment_cart, container, false)
        var recyclerViewP=v.findViewById<RecyclerView>(R.id.recyclerViewP)
        var searchViewP=v.findViewById<SearchView>(R.id.searchViewP)
        var textViewLoction=v.findViewById<TextView>(R.id.textViewLoction)
//        recyclerViewP.layoutManager = LinearLayoutManager(context)
    //    recyclerViewP.adapter = PersonAdapter()
        return v
    }

    }
