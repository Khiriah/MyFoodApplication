package com.example.myfoodapplication.More

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myfoodapplication.Model.Product
import com.example.myfoodapplication.Model.User
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.UserViewModel
import com.google.android.material.textfield.TextInputEditText

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var textViewProfileName = findViewById<TextView>(R.id.textViewProfileName)
        var textViewProfileDate = findViewById<TextView>(R.id.textViewProfileDate)
        var textViewProfileEmail = findViewById<TextView>(R.id.textViewProfileEmail)
        var textViewProfilePhone = findViewById<TextView>(R.id.textViewProfilePhone)

        val viewModel: UserViewModel by viewModels()

        var userId = SharedPrefHelper.getUserId(this)
        viewModel.getUserById(userId).observe(this, {
            textViewProfileName.text = it.name
            textViewProfileDate.text = it.date_of_birth
            textViewProfileEmail.text = it.email
            textViewProfilePhone.text = it.phone
        })

    }
}