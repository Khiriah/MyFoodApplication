package com.example.myfoodapplication.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.UserViewModel
import com.example.myfoodapplication.register.RegisterActivity
import com.example.myfoodapplication.ui.view.HomeActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var email = findViewById<TextInputEditText>(R.id.editTextLogin)
        var password = findViewById<TextInputEditText>(R.id.editTextPassoword)
        var btnLogin = findViewById<Button>(R.id.buttonLogin)
        var btnRegister = findViewById<TextView>(R.id.textViewLogin)


        val viewModelLogin: UserViewModel by viewModels()
        btnLogin.setOnClickListener {
            viewModelLogin.login(this ,email.text.toString(), password.text.toString())
            .observe(this, {
                startActivity(Intent(this, HomeActivity::class.java))
            })
        }



        btnRegister.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}

