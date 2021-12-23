package com.example.myfoodapplication.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ViewModel.UserViewModel
import com.example.myfoodapplication.register.RegisterActivity
import com.example.myfoodapplication.ui.view.HomeActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var email = findViewById<TextInputEditText>(R.id.editTextLogin)
        var password = findViewById<TextInputEditText>(R.id.editTextPassoword)
        var bLogin = findViewById<Button>(R.id.buttonLogin)
        var register = findViewById<TextView>(R.id.textViewLogin)


        val viewModelLogin: UserViewModel by viewModels()
        bLogin.setOnClickListener {
            viewModelLogin.login(email.text.toString(), password.text.toString())
            viewModelLogin.loginLiveData.observe(this, {
                startActivity(Intent(this, HomeActivity::class.java))
            })
        }



        register.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}

