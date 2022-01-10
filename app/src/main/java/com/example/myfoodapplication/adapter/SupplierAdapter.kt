package com.example.myfoodapplication.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.Model.Supplier
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ui.view.FoodActivity
import com.squareup.picasso.Picasso


class SupplierAdapter(var data: List<Supplier>) : RecyclerView.Adapter<PersonHoler>(),

    Filterable {
    var dataSearch: ArrayList<Supplier>

    init {
        dataSearch = ArrayList()
        dataSearch.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHoler {

        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_row_person, parent, false)
        return PersonHoler(v)
    }

    override fun onBindViewHolder(holder: PersonHoler, position: Int) {
        var context = holder.constraintLayoutPerson.context
        holder.pName.text = data[position].name
        holder.pRating.text = data[position].rating
        holder.pType.text = data[position].food_types
        Picasso.get().load(data[position].logo).into(holder.imageViewp)


        holder.itemView.setOnClickListener {
            var intent = Intent(holder.itemView.context, FoodActivity::class.java)
            intent.putExtra("supplier", data[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): Filter.FilterResults {
                var listFilter = ArrayList<Supplier>();
                if (p0 == null || p0.isEmpty()) {
                    listFilter.addAll(data)
                } else {
                    val filterPattern: String = p0.toString().toLowerCase().trim()
                    for (item in data) {
                        if (item.name.toLowerCase().contains(filterPattern)) {
                            listFilter.add(item)
                        }
                    }
                }
                val results = Filter.FilterResults()
                results.values = listFilter
                return results;
            }

            override fun publishResults(p0: CharSequence?, p1: Filter.FilterResults?) {

                dataSearch.clear()

                var x = p1?.values as ArrayList<Supplier>

                println(x)
                dataSearch.addAll(x)

                notifyDataSetChanged()
            }
        }

    }
}

class PersonHoler(v: View) : RecyclerView.ViewHolder(v) {
    var pName = v.findViewById<TextView>(R.id.textViewPName)
    var pType = v.findViewById<TextView>(R.id.textViewPType)
    var pRating = v.findViewById<TextView>(R.id.textViewPRating)
    var imageViewp = v.findViewById<ImageView>(R.id.imageViewPerson)
    var constraintLayoutPerson = v.findViewById<ConstraintLayout>(R.id.constraintLayoutP)
}
