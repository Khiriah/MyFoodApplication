//package com.example.myfoodapplication.adapter
//
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.*
//import androidx.activity.viewModels
//import androidx.recyclerview.widget.RecyclerView
//import com.example.myfoodapplication.Model.Food
//import com.example.myfoodapplication.Model.Order
//import com.example.myfoodapplication.Model.Product
//import com.example.myfoodapplication.R
//import com.example.myfoodapplication.ViewModel.OrderViewModel
//import com.example.myfoodapplication.ui.view.DetailsActivity
//import com.google.firebase.auth.ktx.auth
//import com.google.firebase.ktx.Firebase
//import com.squareup.picasso.Picasso
//
//
//class OrderAdapter  (var data: List<Order>) : RecyclerView.Adapter<OrderHoler>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHoler {
//
//        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_raw_food, parent, false)
//        return OrderHoler(v)
//    }
//
//    override fun onBindViewHolder(holder: OrderHoler, position: Int) {
//
//
//    override fun getItemCount(): Int {
//        return data.size
//    }
//}
//class OrderHoler(v: View) : RecyclerView.ViewHolder(v) {
//    var OrderButton=v.findViewById<Button>(R.id.OrderButton)
//
//
//}