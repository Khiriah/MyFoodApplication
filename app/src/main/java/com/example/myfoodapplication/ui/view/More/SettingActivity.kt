package com.example.myfoodapplication.ui.view.More

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ui.view.FoodActivity
import com.example.myfoodapplication.ui.view.Fragment.MoreFragment
import java.util.*

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)


        /****************************back***************************/
        var imageViewSitting = findViewById<ImageView>(R.id.imageViewSitting)
        imageViewSitting.setOnClickListener {
            finish()
        }
        /****************************back***************************/
//        var arrayCountry= resources.getStringArray(R.array.array_country)
        var spinner = findViewById<Spinner>(R.id.spinnerLanguage)
        var item: Any = ""
    var language    = arrayOf("English","عربي")
        spinner.adapter=ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item,
            language)
//        var spinnerQuantity = findViewById<Spinner>(R.id.spinnerQuantity)
//        var item: Any = 0
//        var QuantityList = arrayOf(1, 2, 3, 4, 5)
//        spinnerQuantity.adapter =
//            ArrayAdapter<Int>(this, android.R.layout.simple_spinner_item, QuantityList)
                    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
//                if (item=="عربي")
//                    setLocale("ar")
//                else
//                    (item=="English")
//                setLocale("en")
//                item = parent!!.getItemAtPosition(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }
    fun setLocale( language: String?) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources: Resources = resources
        val config: Configuration = resources.getConfiguration()
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.getDisplayMetrics())
        var i=intent
        finish()
        startActivity(i)
    }
}