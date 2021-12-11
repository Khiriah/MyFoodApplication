package com.example.myfoodapplication.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.Model.Cart
import com.example.myfoodapplication.Model.Food
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ui.view.DetailsActivity
import com.squareup.picasso.Picasso


class CartAdapter (var data: List<Cart>) : RecyclerView.Adapter<CartHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {

        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_raw_cart, parent, false)
        return CartHolder(v)
    }

    override fun onBindViewHolder(holder: CartHolder, position: Int) {

//        holder.cName.text = data[position].
//        holder.cPrice.text = data[position].

    }

    override fun getItemCount(): Int {
        return data.size
    }
}
class CartHolder(v: View) : RecyclerView.ViewHolder(v) {
    var cName = v.findViewById<TextView>(R.id.textViewCName)
    var cPrice = v.findViewById<TextView>(R.id.textViewCPrice)
    var imageViewC=v.findViewById<ImageView>(R.id.cImageView)

}