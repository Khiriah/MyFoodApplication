package com.example.myfoodapplication.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.OrderViewModel
import com.example.myfoodapplication.ViewModel.UserViewModel
import com.example.myfoodapplication.register.RegisterActivity
import com.example.myfoodapplication.ui.view.Fragment.HomeFragment
import com.example.myfoodapplication.ui.view.HomeActivity
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {
//    lateinit var textViewCreatedAtOrder: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var email = findViewById<TextInputEditText>(R.id.editTextLogin)
        var password = findViewById<TextInputEditText>(R.id.editTextPassoword)
        var btnLogin = findViewById<Button>(R.id.buttonLogin)
        var btnRegister = findViewById<TextView>(R.id.textViewLogin)
//        textViewCreatedAtOrder = findViewById(R.id.textViewCreatedAtOrder)
//        var i=showLocation()


        val viewModelLogin: UserViewModel by viewModels()
        btnLogin.setOnClickListener {
            viewModelLogin.login(this, email.text.toString(), password.text.toString())
                .observe(this, {
//                    checkPermissionForLocation()
                    SharedPrefHelper.getUserId(this)
                    var intent = Intent(this, HomeActivity::class.java)
//                            intent.putExtra("i",i)
                    startActivity(intent)

                })
        }
        btnRegister.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }


//    fun checkPermissionForLocation() {
//
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//            && ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//
//            // show request permission dialog
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(
//                    Manifest.permission.ACCESS_FINE_LOCATION,
//                    Manifest.permission.ACCESS_COARSE_LOCATION
//                ),
//                1
//            )
//
//        } else {
//
//            showLocation()
//        }
//
//    }
//
//
//    @SuppressLint("MissingPermission")
//    fun showLocation():String {
//
//        var locationName =""
//        var locationManager =
//            getSystemService(AppCompatActivity.LOCATION_SERVICE) as? LocationManager
//
//
//        locationManager?.requestLocationUpdates(
//            LocationManager.GPS_PROVIDER, 0, 0f,
//            object : LocationListener {
//                override fun onLocationChanged(location: Location) {
//
//
//                    locationName = "${getCityName(location.latitude, location.longitude)}"
////                Thread() {
////                    var geocoder = Geocoder(this@LoginActivity)
////                    var l = geocoder.getFromLocation(location.latitude, location.longitude, 10)
////
////                    val address = l[0]
////                    println(address.countryName + "  " + address.adminArea)
////                    println(address.getAddressLine(0) + "  " + address.getAddressLine(1))
////                    runOnUiThread{
////                        textView2.text=address.getAddressLine(0) + "  " + address.getAddressLine(1)
////                    }
////                }.start()
//
//                }
//
//            })
//        return locationName
//    }
//
//    fun getCityName(lat: Double, long: Double): String {
//        var cityName = ""
//        var geoCoder = Geocoder(this, Locale.getDefault())
//        var Adress = geoCoder.getFromLocation(lat, long, 1)
//        cityName = Adress.get(0).locality
//        return cityName
//    }
//
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//            showLocation()
//        } else {
//
//            AlertDialog.Builder(this).apply {
//                title = "warning"
//                setMessage("To access location go to Setting-> allow location service")
//                setPositiveButton("Ok", object : DialogInterface.OnClickListener {
//                    override fun onClick(dialog: DialogInterface?, which: Int) {
//
//
//                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
//                        val uri: Uri = Uri.fromParts("package", packageName, null)
//                        intent.data = uri
//                        startActivity(intent)
//                    }
//
//                })
//            }.show()
//        }
//
//
    }
//}
//
//
