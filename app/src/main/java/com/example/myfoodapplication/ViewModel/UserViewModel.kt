package com.example.myfoodapplication.ViewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfoodapplication.Repository.UserRepository
import com.google.firebase.auth.FirebaseUser

class UserViewModel : ViewModel() {
    var registrationlivedata = MutableLiveData<Boolean>()
    fun register(
        email: String,
        password:String,
        phone: String,
        date_of_birth: String,
        gender:String,
        name:String
    ) {
        var urregister = UserRepository()
        registrationlivedata = urregister.register(email,password,phone, date_of_birth,gender,name)



        fun addUserApi(
            email: String,
            fb_id: String,
            phone: String,
            date_of_birth: String,
            gender: String,
            name: String,
            id: String

        ): MutableLiveData<Boolean> {
            urregister.addUserToApi(email, fb_id, phone, date_of_birth, gender, name, id)
                .observeForever {
                    if (it != null) {
                        registrationlivedata.postValue(true)
                    } else
                        registrationlivedata.postValue(false)
                }
            return registrationlivedata
        }
    }

    var loginLiveData = MutableLiveData<FirebaseUser>()
    fun login(email: String, password: String) {
        var ur = UserRepository()
        loginLiveData = ur.login(email, password)
    }
}


