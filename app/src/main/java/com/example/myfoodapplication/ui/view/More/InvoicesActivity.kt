package com.example.myfoodapplication.ui.view.More

import android.R.attr.label
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ui.view.Fragment.MoreFragment


class InvoicesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invoices)

var copy1=findViewById<TextView>(R.id.textViewCopy)
        var copy2=findViewById<TextView>(R.id.textViewCopy1)
        var buttonCopy=findViewById<Button>(R.id.buttonCopy)
        var buttonCopy1=findViewById<Button>(R.id.buttonCopy1)

buttonCopy.setOnClickListener {
//    val clipboard: ClipboardManager =
//        getSystemService<Any>(Context.CLIPBOARD_SERVICE) as ClipboardManager
////    copy1 = edidata.getText().toString();
////    val clip = ClipData.newPlainText("copy1" ,copy1)
//    clipboard.setPrimaryClip(clip)
}



        /****************************back***************************/
        var imageViewInvoices = findViewById<ImageView>(R.id.imageViewInvoices)
        imageViewInvoices.setOnClickListener {
            finish()
        }
        /****************************back***************************/
    }
}