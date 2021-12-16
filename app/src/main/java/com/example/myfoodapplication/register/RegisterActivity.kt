package com.example.myfoodapplication.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ViewModel.UserViewModel
import com.example.myfoodapplication.login.LoginActivity
import com.example.myfoodapplication.ui.view.HomeActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var email = findViewById<TextInputEditText>(R.id.editTextTextEmailAddress2)
        var password = findViewById<TextInputEditText>(R.id.editTextTextPassword2)
        var phone = findViewById<EditText>(R.id.editTextPhone)
        var name = findViewById<EditText>(R.id.editTextTextPersonName)
        var loginin = findViewById<TextView>(R.id.textViewLogin)
        var bRegister = findViewById<Button>(R.id.buttonRegister)
        var date_of_birth = findViewById<EditText>(R.id.editTextdate_of_birth)
        var genderMale = findViewById<RadioButton>(R.id.radioButtonGenderMale)
        var genderFemale = findViewById<RadioButton>(R.id.radioButtonGenderFemale)
//     var image= findViewById<ImageView>(R.id.textViewLogin)


        val viewModelregister: UserViewModel by viewModels()
        bRegister.setOnClickListener {
            viewModelregister.register(
                email.text.toString(),
                password.text.toString(),
                phone.text.toString(),
                date_of_birth.text.toString(),
                genderMale.text.toString() ,
                name.text.toString()
            )
            viewModelregister.registrationlivedata.observe(this, {
                if (it == true) {
                    startActivity(Intent(this, HomeActivity::class.java))
                } else Toast.makeText(this, "wrong in registration ", Toast.LENGTH_SHORT).show()
            })
        }

        loginin.setOnClickListener {
            var i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
    }
}
