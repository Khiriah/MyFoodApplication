package com.example.myfoodapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myfoodapplication.Model.Supplier
import com.example.myfoodapplication.Repository.SupplierRepository

class SupplierViewModel : ViewModel() {


    var SupplierRepo= SupplierRepository()

    fun getallSuppliers(): LiveData<List<Supplier>> {
        return SupplierRepo.getallSuppliers()
    }
}