package com.example.myfoodapplication.Fragment

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.SupplierViewModel
import com.example.myfoodapplication.adapter.ProductAdapter
import com.example.myfoodapplication.adapter.SupplierAdapter
import com.example.myfoodapplication.ui.view.HomeActivity
import java.util.*


class HomeFragment : Fragment() {

    lateinit var textViewLoction: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var context=inflater.context
        var v = inflater.inflate(R.layout.fragment_home, container, false)
        var pRecyclerView = v.findViewById<RecyclerView>(R.id.recyclerViewP)
//      var pSearchView = v.findViewById<SearchView>(R.id.searchViewP)
       textViewLoction = v.findViewById<TextView>(R.id.textViewLoction)
//        checkPermissionForLocation(context,HomeActivity())
//        pSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                if(ProductAdapter.contains(query))
//                    adapter.filter.filter(query)
//                else
//                    Toast.makeText(this@MainActivity, "City is not found", Toast.LENGTH_SHORT).show()
//
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                adapter.filter.filter(newText)
//                return false
//            }

        val viewModel: SupplierViewModel by viewModels()

        pRecyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.getallSuppliers().observe(this, { list ->
//            var supID = list[0].id
            pRecyclerView.adapter = SupplierAdapter(list)

        })
        return v
    }
//    fun checkPermissionForLocation(context: Context,activity: AppCompatActivity) {
//
//        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//            && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
//        ) {
//
//            // show request permission dialog
//            ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION),1)
//
//        }else{
//
//            showLocation()
//        }
//
//    }
//
//
//    @SuppressLint("MissingPermission")
//    fun showLocation(){
//
//        var locationManager = context?.getSystemService(LOCATION_SERVICE)as? LocationManager
////            getSystemService(LOCATION_SERVICE) as? LocationManager
//
//
//        locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0f,
//            object : LocationListener {
//                override fun onLocationChanged(location: Location) {
//
//
//                    textViewLoction.text="${getCityName(location.latitude,location.longitude)}"
//                }
//
//            })
//    }
//    fun getCityName(lat: Double,long: Double):String{
//        var cityName = ""
//        var geoCoder = Geocoder(context, Locale.getDefault())
//        var Adress = geoCoder.getFromLocation(lat,long,1)
//        cityName = Adress.get(0).locality
//        return cityName
//    }
//
//
//    override fun onRequestPermissionsResult(context: Context , requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
//
//            showLocation()
//        }else{
//
//            AlertDialog.Builder(context).apply {
//              var  title= "warning"
//                setMessage("To access location go to Setting-> allow location service")
//                setPositiveButton("Ok", object : DialogInterface.OnClickListener {
//                    override fun onClick(dialog: DialogInterface?, which: Int) {
//
//
//                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
//                        val uri: Uri = Uri.fromParts("package", context!!.packageName, null)
//                        intent.data = uri
//                        startActivity(intent)
//                    }
//
//                })
//            }.show()
//        }


    }




