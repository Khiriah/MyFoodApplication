package com.example.myfoodapplication.ui.view.More

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ui.view.FoodActivity
import com.example.myfoodapplication.ui.view.Fragment.MoreFragment

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        /****************************back***************************/
        var imageViewHelp = findViewById<ImageView>(R.id.imageViewHelp)
        imageViewHelp.setOnClickListener {
            finish()
        }
        /****************************back***************************/

    }
}