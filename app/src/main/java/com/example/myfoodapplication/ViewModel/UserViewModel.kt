package com.example.myfoodapplication.ViewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfoodapplication.Model.User
import com.example.myfoodapplication.Repository.UserRepository
import com.google.firebase.auth.FirebaseUser

class UserViewModel : ViewModel() {
    lateinit var registrationlivedata : MutableLiveData<User>
    fun register(
        email: String,
        password:String,
        phone: String,
        date_of_birth: String,
        gender:String,
        name:String
    ):MutableLiveData<Boolean> {
        var urregister = UserRepository()
        var registration = urregister.register(email, password, phone, date_of_birth, gender, name)

        return registration
    }

        fun addUserApi(
            email: String,
            fb_id: String,
            phone: String,
            date_of_birth: String,
            gender: String,
            name: String,
            id: String

        ){
            var uAddApi=UserRepository()
            registrationlivedata=uAddApi.addUserToApi(email,fb_id,phone,date_of_birth,gender,name,id)

        }


    var loginLiveData = MutableLiveData<FirebaseUser>()
    fun login(email: String, password: String) {
        var ur = UserRepository()
        loginLiveData = ur.login(email, password)
    }
}


