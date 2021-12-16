package com.example.myfoodapplication.Repository


import androidx.lifecycle.MutableLiveData
import com.example.myfoodapplication.Model.Supplier
import com.example.myfoodapplication.network.API
import com.example.myfoodapplication.network.SupplierService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SupplierRepository {
    fun getallSupplier(): MutableLiveData<List<Supplier>> {

        var mutableLiveData= MutableLiveData<List<Supplier>>()

        val SupplierService= API.getInstance().create(SupplierService::class.java)
        val callSupplierList=SupplierService.getallPersons()
        callSupplierList.enqueue(object : Callback<List<Supplier>> {
            override fun onResponse(call: Call<List<Supplier>>, response: Response<List<Supplier>>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Supplier>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return mutableLiveData
    }
}