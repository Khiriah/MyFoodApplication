package com.example.myfoodapplication.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfoodapplication.Model.User
import com.example.myfoodapplication.Repository.FoodRepository
import com.example.myfoodapplication.Repository.UserRepository
import com.example.myfoodapplication.Util.SharedPrefHelper


class UserViewModel : ViewModel() {
    lateinit var registrationlivedata: MutableLiveData<User>
    fun register(
        email: String,
        password: String,
        phone: String,
        date_of_birth: String,
        gender: String,
        name: String
    ): MutableLiveData<Boolean> {
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

    ) {
        var uAddApi = UserRepository()
        registrationlivedata =
            uAddApi.addUserToApi(email, fb_id, phone, date_of_birth, gender, name, id)

    } var uAddApi = UserRepository()
    fun updateUser(
        email: String,
        fb_id: String,
        phone: String,
        date_of_birth: String,
        gender: String,
        name: String,
        id: String

    ):LiveData<User> {
        return uAddApi.updateUser(email, fb_id, phone, date_of_birth, gender, name, id)


    }




    //    var loginLiveData = MutableLiveData<FirebaseUser>()
    fun login(context: Context, email: String, password: String): MutableLiveData<Boolean> {
        var liveData = MutableLiveData<Boolean>()
        var userRepository = UserRepository()
        userRepository.login(email, password).observeForever {
            userRepository.getUserByFbId(it.uid).observeForever {
                var userId = it[0].id
                SharedPrefHelper.saveUserId(context, userId)
                liveData.postValue(true)
            }
        }
        return liveData
    }

        var UserRepo= UserRepository()
        fun getUserById(id: String): MutableLiveData<User> {
        return UserRepo.getUserById(id)

    }

}


