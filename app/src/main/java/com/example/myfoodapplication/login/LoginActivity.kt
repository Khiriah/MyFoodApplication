package com.example.myfoodapplication.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myfoodapplication.R
import com.example.myfoodapplication.register.RegisterActivity
import com.example.myfoodapplication.ui.view.HomeActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var email = findViewById<EditText>(R.id.editTextLogin)
        var password = findViewById<EditText>(R.id.editTextPassoword)
        var bLogin = findViewById<Button>(R.id.buttonLogin)
        var register = findViewById<TextView>(R.id.textViewLogin)

        bLogin.setOnClickListener {

            var auth = Firebase.auth

            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        var user = auth.currentUser
                        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                        println("Login Success " + user?.uid)
                        var intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {

                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }

                }

        }

        register.setOnClickListener {

            var i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }


    }
}