package com.example.myfoodapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myfoodapplication.Model.Person
import com.example.myfoodapplication.Repository.PersonRepository

class PersonViewModel : ViewModel() {


    var personRepository= PersonRepository()

    fun getPosts(): LiveData<List<Person>> {
        return personRepository.getallPersons()
    }
}