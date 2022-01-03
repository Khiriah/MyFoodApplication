package com.example.myfoodapplication.More

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import com.example.myfoodapplication.Model.User
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.UserViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class ProfileActivity : AppCompatActivity() {
    lateinit var auth1: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var profileName = findViewById<EditText>(R.id.ProfileName)
        var profileDate = findViewById<EditText>(R.id.ProfileDate)
        var profileEmail = findViewById<EditText>(R.id.ProfileEmail)
        var profilePhone = findViewById<EditText>(R.id.ProfilePhone)
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

        val viewModel: UserViewModel by viewModels()

        var userId = SharedPrefHelper.getUserId(this)
        viewModel.getUserById(userId).observe(this, {
            profileName.setText(it.name)
            profileDate.setText(it.date_of_birth)
            profileEmail.setText(it.email)
            profilePhone.setText(it.phone)
            gender = it.gender
        })

        var btnUbdate = findViewById<Button>(R.id.buttonUbdate)
        btnUbdate.setOnClickListener {
            var userId = SharedPrefHelper.getUserId(this)
            if (userId.isNotEmpty()) {
                var user = User(
                    profileDate.text.toString(),
                    profileEmail.text.toString(),
                    auth1.currentUser?.uid.toString(),
                    gender,
                    userId,
                    profileName.text.toString(),
                    profilePhone.text.toString()
                )

                viewModel.updateUser(
                    user.email,
                    user.fb_id,
                    user.phone,
                    user.date_of_birth,
                    user.gender,
                    user.name,
                    userId
                ).observeForever {
                    if (it != null) {
                        Toast.makeText(this, "Ubdate", Toast.LENGTH_SHORT).show()


                    } else {
                        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()

                    }
                }
            }
            ///////////////end of the button ubdate ////////////////////////////


        }
    }
}