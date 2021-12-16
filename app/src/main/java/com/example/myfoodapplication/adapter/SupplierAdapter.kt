package com.example.myfoodapplication.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.Model.Supplier
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ui.view.FoodActivity
import com.squareup.picasso.Picasso


class SupplierAdapter (var data:List<Supplier>) : RecyclerView.Adapter<PersonHoler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHoler {

        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_row_person, parent, false)
        return PersonHoler(v)
    }

    override fun onBindViewHolder(holder: PersonHoler, position: Int) {
        var constraint = holder.constraintLayoutPerson.context
        holder.pName.text = data[position].name
        holder.pRating.text = data[position].rating
        holder.pType.text=data[position].food_types
        Picasso.get().load(data[position].logo).into(holder.imageViewp)
        holder.itemView.setOnClickListener {
            var intent = Intent(holder.itemView.context, FoodActivity::class.java)
            constraint.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
class PersonHoler(v: View) : RecyclerView.ViewHolder(v) {
    var pName = v.findViewById<TextView>(R.id.textViewPName)
    var pType = v.findViewById<TextView>(R.id.textViewPType)
    var pRating = v.findViewById<TextView>(R.id.textViewPRating)
    var imageViewp=v.findViewById<ImageView>(R.id.imageViewPerson)
    var constraintLayoutPerson = v.findViewById<ConstraintLayout>(R.id.constraintLayoutP)
}
