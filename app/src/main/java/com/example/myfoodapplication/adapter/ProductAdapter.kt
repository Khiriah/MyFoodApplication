package com.example.myfoodapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.Model.Product
import com.example.myfoodapplication.R
import com.squareup.picasso.Picasso


class ProductAdapter (var data: List<Product>) : RecyclerView.Adapter<CartHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {

        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_raw_cart, parent, false)
        return CartHolder(v)
    }

    override fun onBindViewHolder(holder: CartHolder, position: Int) {
        var spinner = holder.spinner.context
        holder.oName.text = data[position].name
        holder.oPrice.text = data[position].price
        Picasso.get().load(data[position].photo).into(holder.orderImageView)
//        holder.OrderButton.setOnClickListener {
//            val viewModel: OrderViewModel by viewModels()
//
//
//            val order= Order(
//                "",
//                "",
//                0,
//
//
//
//
//            )
//
//            var oId=order.id
//            var order_date=order.order_date
//            var total_price=order.total_price
//
//
//            OrderViewModel.addItemToOrder(oId,order_date,total_price)
//
//
//        }


//holder.imageViewRemove.setOnClickListener {
//    fun deleteItem(cart: Cart?) {
//        CartViewModel.removeItemFromCart(Cart)
//    }

    }
//    var auth = Firebase.auth
//    var uId = auth.currentUser?.uid

    override fun getItemCount(): Int {
        return data.size
    }
}
class CartHolder(v: View) : RecyclerView.ViewHolder(v) {
    var oName = v.findViewById<TextView>(R.id.textViewCName)
    var oPrice = v.findViewById<TextView>(R.id.textViewCPrice)
    var imageViewRemove=v.findViewById<ImageView>(R.id.cImageViewRemove)
    var orderImageView=v.findViewById<ImageView>(R.id.cartImageView)
    var spinner = v.findViewById<Spinner>(R.id.spinnerCart)
    var OrderButton=v.findViewById<Button>(R.id.OrderButton)

}