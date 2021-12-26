package com.example.myfoodapplication.register

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import com.example.myfoodapplication.Model.User
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.UserViewModel
import com.example.myfoodapplication.login.LoginActivity
import com.example.myfoodapplication.ui.view.HomeActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.*

class RegisterActivity : AppCompatActivity() {
    lateinit var auth1: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var email = findViewById<TextInputEditText>(R.id.editTextTextEmailAddress2)
        var password = findViewById<TextInputEditText>(R.id.editTextTextPassword2text)
        var phone = findViewById<TextInputEditText>(R.id.editTextPhonetext)
        var name = findViewById<TextInputEditText>(R.id.editTextTextPersonNametext)
        var loginin = findViewById<TextView>(R.id.textViewLogin)
        var bRegister = findViewById<Button>(R.id.buttonRegister)
        var date_of_birth = findViewById<TextInputEditText>(R.id.editTextdate_of_birthtext)
        var genderMale = findViewById<RadioButton>(R.id.radioButtonGenderMale)
        var genderFemale = findViewById<RadioButton>(R.id.radioButtonGenderFemale)
        var gender1=findViewById<RadioGroup>(R.id.radioGroup)
        var gender:String = ""
//     var image= findViewById<ImageView>(R.id.textViewLogin)
        auth1 = Firebase.auth

        gender1.setOnCheckedChangeListener { group, checkedId ->
            gender = when(checkedId){
                R.id.radioButtonGenderMale -> "Male"
                R.id.radioButtonGenderFemale -> "Female"
                else -> ""
            }


        }




        val viewModelregister: UserViewModel by viewModels()
        bRegister.setOnClickListener {
            viewModelregister.register(
                email.text.toString(),
                password.text.toString(),
                phone.text.toString(),
                date_of_birth.text.toString(),
                gender,
                name.text.toString()
            ).observe(this,
                {
                    var email = email.text.toString()
                    var phone = phone.text.toString()
                    var date = date_of_birth.text.toString()
                    var name = name.text.toString()
                    var fb_id = auth1.currentUser?.uid.toString()
                    var user = User(date, email, fb_id, gender, "1", name, phone)
                    viewModelregister.addUserApi(
                        user.email,
                        user.fb_id,
                        user.phone,
                        user.date_of_birth,
                        user.gender,
                        user.name,
                        user.id

                    )
                    viewModelregister.registrationlivedata.observe(this, {

                        SharedPrefHelper.saveUserId(this, it.id)
                        SharedPrefHelper.getUserId(this)
                        startActivity(Intent(this, HomeActivity::class.java))
                    })

                }
            )
        }

        loginin.setOnClickListener {
            var i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }

        var c = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)
        var day = c.get(Calendar.DAY_OF_MONTH)



        date_of_birth.setOnClickListener {

            var datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    date_of_birth.setText("$dayOfMonth/${month + 1}/$year")
                }, year, month, day
            )
            datePickerDialog.show()

        }
    }
}

