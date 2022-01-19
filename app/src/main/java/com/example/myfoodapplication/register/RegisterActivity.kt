package com.example.myfoodapplication.register

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import com.example.myfoodapplication.Model.User
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.RegisterValidations
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


        /********************************gender*********************************/
        var gender1 = findViewById<RadioGroup>(R.id.radioGroup)
        var gender: String = ""
        auth1 = Firebase.auth

        gender1.setOnCheckedChangeListener { group, checkedId ->
            gender = when (checkedId) {
                R.id.radioButtonGenderMale -> "Male"
                R.id.radioButtonGenderFemale -> "Female"
                else -> ""
            }
        }
        /********************************End of gender*********************************/




        /********************************Register*********************************/
        var bRegister = findViewById<Button>(R.id.buttonRegister)
        var emailEditText = findViewById<TextInputEditText>(R.id.editTextTextEmailAddress2)
        var passwordEditText = findViewById<TextInputEditText>(R.id.editTextTextPassword2text)
        var phoneEditText = findViewById<TextInputEditText>(R.id.editTextPhonetext)
        var nameEditText = findViewById<TextInputEditText>(R.id.editTextTextPersonNametext)
        var date_of_birthEditText = findViewById<TextInputEditText>(R.id.editTextdate_of_birthtext)


        val viewModelregister: UserViewModel by viewModels()
        bRegister.setOnClickListener {
            var email = emailEditText.text.toString()
            var phone = phoneEditText.text.toString()
            var date = date_of_birthEditText.text.toString()
            var name = nameEditText.text.toString()
            var password = passwordEditText.text.toString()
            if (name.isNotEmpty()
                && password.isNotEmpty()
                && email.isNotEmpty()
                && date.isNotEmpty()
                && phone.isNotEmpty()
            ) {

                if (RegisterValidations.emailIsValid(email)) {
                    if (RegisterValidations.passwordIsValid(password)) {
                        viewModelregister.register(
                            email,
                            password,
                            phone,
                            date,
                            gender,
                            name
                        ).observe(this,
                            {
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


                    } else {
                        Toast.makeText(
                            this,
                            "Make sure your password is strong.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this,
                        "Make sure you typed your email address correctly.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    this,
                    "Registration fields must not be empty",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        /********************************End of Register*********************************/





        /********************************LoginActivity*********************************/
        var loginin = findViewById<TextView>(R.id.textViewLogin)
        loginin.setOnClickListener {
            var i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
        /****************************************End of intent************************/






        /*************************** Date of birth*****************************/
        var c = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)
        var day = c.get(Calendar.DAY_OF_MONTH)
        date_of_birthEditText.setOnClickListener {

            var datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    date_of_birthEditText.setText("$dayOfMonth/${month + 1}/$year")
                }, year, month, day
            )
            datePickerDialog.show()

        }
        /*****************************End of Date of birth**********************/
    }
}

