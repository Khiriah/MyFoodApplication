package com.example.myfoodapplication.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.Model.Product
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.OrderViewModel
import com.example.myfoodapplication.ViewModel.ProductViewModel
import com.example.myfoodapplication.ui.view.OrderActivity
import com.squareup.picasso.Picasso



class ProductAdapter (var data: MutableList<Product>) : RecyclerView.Adapter<CartHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {

        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_raw_cart, parent, false)
        return CartHolder(v)
    }

    override fun onBindViewHolder( holder: CartHolder, position: Int) {
        holder.oName.text = data[position].name
        holder.oPrice.text = data[position].price
        Picasso.get().load(data[position].photo).into(holder.orderImageView)




        /*********************imageViewRemove*******************************/
holder.imageViewRemove.setOnClickListener {
    var context = holder.itemView.context
    var userId = SharedPrefHelper.getUserId(context)
    ProductViewModel().deletefromCart(data[position].id,userId,data[position].orderId ).observeForever {
            data.removeAt(position)
        notifyDataSetChanged()
    }
    }
    }
    /*********************end of imageViewRemove*********************/




    override fun getItemCount(): Int {
        return data.size
    }
}
class CartHolder(v: View) : RecyclerView.ViewHolder(v) {
    var oName = v.findViewById<TextView>(R.id.textViewCName)
    var oPrice = v.findViewById<TextView>(R.id.textViewCPrice)
    var imageViewRemove=v.findViewById<ImageView>(R.id.cImageViewRemove)
    var orderImageView=v.findViewById<ImageView>(R.id.cartImageView)

}