package com.example.myfoodapplication.Repository

import androidx.lifecycle.MutableLiveData
import com.example.myfoodapplication.Model.Food
import com.example.myfoodapplication.Model.User
import com.example.myfoodapplication.network.API
import com.example.myfoodapplication.network.UserService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    private lateinit var auth: FirebaseAuth
    fun login(email: String, password: String): MutableLiveData<FirebaseUser> {
        auth = Firebase.auth
        var mutableLiveData = MutableLiveData<FirebaseUser>()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    mutableLiveData.value = auth.currentUser
                } else {
                    println("error")
                }
            }
        return mutableLiveData
    }

    fun register(
        email: String,
        password: String,
        phone: String,
        date_of_birth: String,
        gender: String,
        name: String

    ): MutableLiveData<Boolean> {
        var mutableLiveData = MutableLiveData<Boolean>()
        auth = Firebase.auth
        //  var db = Firebase.firestore
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val u = hashMapOf(
                        "email" to auth.currentUser?.email,
                        "phone" to phone,
                        " date_of_birth" to date_of_birth,
                        "gender" to gender,
                        "name" to name
                    )
                    var db = Firebase.firestore
                    db.collection("users").document(auth.currentUser?.uid.toString())
                        .set(u).addOnCompleteListener {
                            if (it.isSuccessful) {
                                mutableLiveData.postValue(true)
                            } else {
                                mutableLiveData.postValue(false)
                            }
                        }
                } else {
                    println("Error")
                }

            }.addOnFailureListener {
                println(it.message)
            }
        return mutableLiveData

    }


    fun addUserToApi(
        email: String,
        fb_id: String,
        phone: String,
        date_of_birth: String,
        gender: String,
        name: String,
        id: String

    ): MutableLiveData<User> {
        var mutableLiveData = MutableLiveData<User>()
        val userServies = API.getInstance().create(UserService::class.java)
        val callUser = userServies.addUser(
            User(date_of_birth, email, fb_id, gender, id, name, phone)
        )
        callUser.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                println("Error")
            }

        })
        return mutableLiveData

    }
    fun getUserByFbId(id:String): MutableLiveData<List<User>> {
        val userService = API.getInstance().create(UserService::class.java)
        var mutableLiveData= MutableLiveData<List<User>>()
//        auth.currentUser?.uid.toString()

        val user =userService.getUserByFbId(id)
        user.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }

        })


        return mutableLiveData
    }



    val user= API.getInstance().create(UserService::class.java)

    fun getUserById(id:String): MutableLiveData<User> {

        var mutableLiveData= MutableLiveData<User>()


        val callFoodList=user.getUserById(id)
        callFoodList.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {

            }

        })


        return mutableLiveData
    }

    fun updateUser( email: String,
                    fb_id: String,
                    phone: String,
                    date_of_birth: String,
                    gender: String,
                    name: String,
                    id: String): MutableLiveData<User> {

        var mutableLiveData= MutableLiveData<User>()


        val callFoodList=user.updateUser(id,User(date_of_birth, email, fb_id, gender, id, name, phone))
        callFoodList.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {

            }

        })


        return mutableLiveData
    }

//    fun getUserById(id:String): MutableLiveData<List<User>> {
//        val userService = API.getInstance().create(UserService::class.java)
//        var mutableLiveData= MutableLiveData<List<User>>()
////        auth.currentUser?.uid.toString()
//
//        val user =userService.getUserById(id)
//        user.enqueue(object : Callback<List<User>> {
//            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
//                mutableLiveData.postValue(response.body())
//            }
//
//            override fun onFailure(call: Call<List<User>>, t: Throwable) {
//
//            }
//
//        })
//
//
//        return mutableLiveData
//    }



}

