package com.example.myfoodapplication.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ui.view.DetailsActivity
import com.example.myfoodapplication.Model.Food
import com.squareup.picasso.Picasso


class FoodAdapter (var data: List<Food>) : RecyclerView.Adapter<FoodHoler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHoler {

        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_raw_food, parent, false)
        return FoodHoler(v)
    }

    override fun onBindViewHolder(holder: FoodHoler, position: Int) {
        var constraint = holder.constraintLayoutFood.context
        holder.fName.text = data[position].FoodName
        holder.fPrice.text = data[position].FoodPrice
  //      holder.fCheckBox!!.isChecked == data[position].FoodState
//        holder.fCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
//
//
//        }
        Picasso.get().load(data[position].FoodImage).into(holder.imageView)
        holder.itemView.setOnClickListener {
            var intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.putExtra("Foods", data[position])
            constraint.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
class FoodHoler(v: View) : RecyclerView.ViewHolder(v) {
    var fName = v.findViewById<TextView>(R.id.textViewFName)
    var fPrice = v.findViewById<TextView>(R.id.textViewFPrice)
    var imageView=v.findViewById<ImageView>(R.id.imageViewFood2)
//    var fCheckBox=v.findViewById<CheckBox>(R.id.fCheckBox)
    var constraintLayoutFood = v.findViewById<ConstraintLayout>(R.id.constraintLayoutFood)
}