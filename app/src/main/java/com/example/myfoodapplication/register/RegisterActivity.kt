package com.example.myfoodapplication.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myfoodapplication.R
import com.example.myfoodapplication.login.LoginActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var email = findViewById<EditText>(R.id.editTextTextEmailAddress2)
        var password = findViewById<EditText>(R.id.editTextTextPassword2)
        var phone = findViewById<EditText>(R.id.editTextPhone)
        var fullname = findViewById<EditText>(R.id.editTextTextPersonName)
        var loginin = findViewById<TextView>(R.id.textViewLogin)
        var bRegister = findViewById<Button>(R.id.buttonRegister)
        loginin.setOnClickListener {
            var i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }

        bRegister.setOnClickListener {

            var auth = Firebase.auth

            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {

                        println("User has been registered successfully with UID " + auth.currentUser?.uid)

                        val user = hashMapOf(
                            "email" to auth.currentUser?.email,
                            "phone" to phone.text.toString(),
                            "fullname" to fullname.text.toString()

                        )

                        var db = Firebase.firestore
                        db.collection("users").document(auth.currentUser?.uid.toString())
                            .set(user)
                    } else {

                        println("Error")
                    }
                }.addOnFailureListener {
                    println(it.message)
                }
                        var intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    }
                }

        }
