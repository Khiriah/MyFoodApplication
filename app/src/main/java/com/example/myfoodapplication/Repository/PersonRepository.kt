package com.example.myfoodapplication.Repository


import androidx.lifecycle.MutableLiveData
import com.example.myfoodapplication.Model.Person
import com.example.myfoodapplication.network.API
import com.example.myfoodapplication.network.PersonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository {
    fun getallPersons(): MutableLiveData<List<Person>> {

        var mutableLiveData= MutableLiveData<List<Person>>()

        val PersonService= API.getInstance().create(PersonService::class.java)
        val callPersonList=PersonService.getallPersons()
        callPersonList.enqueue(object : Callback<List<Person>> {
            override fun onResponse(call: Call<List<Person>>, response: Response<List<Person>>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Person>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return mutableLiveData
    }
}