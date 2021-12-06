package com.example.myfoodapplication.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ui.view.FoodActivity
import com.example.myfoodapplication.viewModel.Person

class PersonAdapter (var data: MutableList<Person>) : RecyclerView.Adapter<PersonHoler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHoler {

        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_row_person, parent, false)
        return PersonHoler(v)
    }

    override fun onBindViewHolder(holder: PersonHoler, position: Int) {
        var constraint = holder.constraintLayoutPerson.context
        holder.pName.text = data[position].namePerson
        holder.pRating.text = data[position].RatingPerson
        holder.itemView.setOnClickListener {
            var intent = Intent(holder.itemView.context, FoodActivity::class.java)
            intent.putExtra("Persons", data[position])
            constraint.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
class PersonHoler(v: View) : RecyclerView.ViewHolder(v) {
    var pName = v.findViewById<TextView>(R.id.textViewPName)
    var pType = v.findViewById<CheckBox>(R.id.textViewPType)
    var pRating = v.findViewById<TextView>(R.id.textViewPRating)
    var constraintLayoutPerson = v.findViewById<ConstraintLayout>(R.id.constraintLayoutP)
}