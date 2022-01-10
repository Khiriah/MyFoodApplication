package com.example.myfoodapplication.login

import android.Manifest
import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.example.myfoodapplication.Model.Order
import com.example.myfoodapplication.R
import com.example.myfoodapplication.Util.SharedPrefHelper
import com.example.myfoodapplication.ViewModel.UserViewModel
import com.example.myfoodapplication.register.RegisterActivity
import com.example.myfoodapplication.ui.view.Fragment.HomeFragment
import com.example.myfoodapplication.ui.view.HomeActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {
    lateinit var textViewLoction: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var email = findViewById<TextInputEditText>(R.id.editTextLogin)
        var password = findViewById<TextInputEditText>(R.id.editTextPassoword)
        var btnLogin = findViewById<Button>(R.id.buttonLogin)
        var btnRegister = findViewById<TextView>(R.id.textViewLogin)
        textViewLoction = findViewById(R.id.textViewLoction)

        val viewModelLogin: UserViewModel by viewModels()
        btnLogin.setOnClickListener {
            var i=textViewLoction.text
            viewModelLogin.login(this, email.text.toString(), password.text.toString())
                .observe(this, {
                    checkPermissionForLocation()

                    var intent = Intent(this, HomeFragment::class.java)
                    intent.putExtra("i",i)
                    startActivity(intent)

                })
        }



        btnRegister.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }


    fun checkPermissionForLocation() {

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            // show request permission dialog
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                1
            )

        } else {

            showLocation()
        }

    }


    @SuppressLint("MissingPermission")
    fun showLocation() {

        var locationManager =
            getSystemService(AppCompatActivity.LOCATION_SERVICE) as? LocationManager


        locationManager?.requestLocationUpdates(
            LocationManager.GPS_PROVIDER, 0, 0f,
            object : LocationListener {
                override fun onLocationChanged(location: Location) {


                    textViewLoction.text = "${getCityName(location.latitude, location.longitude)}"
//                Thread() {
//                    var geocoder = Geocoder(this@LoginActivity)
//                    var l = geocoder.getFromLocation(location.latitude, location.longitude, 10)
//
//                    val address = l[0]
//                    println(address.countryName + "  " + address.adminArea)
//                    println(address.getAddressLine(0) + "  " + address.getAddressLine(1))
//                    runOnUiThread{
//                        textView2.text=address.getAddressLine(0) + "  " + address.getAddressLine(1)
//                    }
//                }.start()

                }

            })
    }

    fun getCityName(lat: Double, long: Double): String {
        var cityName = ""
        var geoCoder = Geocoder(this, Locale.getDefault())
        var Adress = geoCoder.getFromLocation(lat, long, 1)
        cityName = Adress.get(0).locality
        return cityName
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            showLocation()
        } else {

            AlertDialog.Builder(this).apply {
                title = "warning"
                setMessage("To access location go to Setting-> allow location service")
                setPositiveButton("Ok", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {


                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                        val uri: Uri = Uri.fromParts("package", packageName, null)
                        intent.data = uri
                        startActivity(intent)
                    }

                })
            }.show()
        }


    }
}


