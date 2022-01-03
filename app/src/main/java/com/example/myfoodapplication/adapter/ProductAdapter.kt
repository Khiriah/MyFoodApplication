package com.example.myfoodapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.animation.content.Content
import com.example.myfoodapplication.Model.Product
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.ProductViewModel
import com.example.myfoodapplication.network.API
import com.example.myfoodapplication.network.ProductService
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductAdapter (var data: List<Product>) : RecyclerView.Adapter<CartHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {

        var v = LayoutInflater.from(parent.context).inflate(R.layout.list_raw_cart, parent, false)
        return CartHolder(v)
    }

    override fun onBindViewHolder( holder: CartHolder, position: Int) {
      // var spinner = holder.spinner.context
        holder.oName.text = data[position].name
        holder.oPrice.text = data[position].price
        Picasso.get().load(data[position].photo).into(holder.orderImageView)
//        holder.OrderButton.setOnClickListener {
//        }

        ///////////////imageViewRemove////////////////////////////
holder.imageViewRemove.setOnClickListener {
    var context = holder.itemView.context
    var userId = SharedPrefHelper.getUserId(context)
    var orderid = SharedPrefHelper.getOrderId(context)
//    val productViewModel: ProductViewModel by viewModels()
//       var product = Product(
//           "",
//           "",
//           "",
//           "",
//           "",
//           orderid,
//           "",
//           "",
//           1
//       )
    ProductViewModel().deletefromCart(userId,data[position].orderId).observeForever {
//        data.rem
        }
    }
    ///////////////end of imageViewRemove ////////////////////////////
    }


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