package com.example.myfoodapplication.ui.view.More

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
import com.example.myfoodapplication.ui.view.FoodActivity
import com.example.myfoodapplication.ui.view.Fragment.MoreFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.*

class ProfileActivity : AppCompatActivity() {
    lateinit var auth1: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)



        /****************************back***************************/
        var imageViewProfile = findViewById<ImageView>(R.id.imageViewProfile)
        imageViewProfile.setOnClickListener {
            finish()
        }
        /****************************back***************************/

        /*********************************** gender ****************************************/
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
        /***************************************************************************/




        /***************************button ubdate profile*********************/
        var profileName = findViewById<EditText>(R.id.ProfileName)
        var profileDate = findViewById<EditText>(R.id.ProfileDate)
        var profileEmail = findViewById<EditText>(R.id.ProfileEmail)
        var profilePhone = findViewById<EditText>(R.id.ProfilePhone)
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
                    gender,
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
        }
     /******************************end of the button ubdate *************************/




        /****************************** button SignOut *************************/
        var btnSignOut=findViewById<Button>(R.id.btnSignOut)
            btnSignOut.setOnClickListener {
                Firebase.auth.signOut()
                if (it != null) {
                    SharedPrefHelper.clearShardPreferences(this)
                }

                startActivity(Intent(this, LoginActivity::class.java))

            }
        /*******************end of the button SignOut ************************/



        /*************************** Date of birth*****************************/
        var c = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)
        var day = c.get(Calendar.DAY_OF_MONTH)
        profileDate.setOnClickListener {
            var datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    profileDate.setText("$dayOfMonth/${month + 1}/$year")
                }, year, month, day
            )
            datePickerDialog.show()
        }
        /*****************************End of Date of birth**********************/


    }
}