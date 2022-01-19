package com.example.myfoodapplication.Util

import android.content.Context
import android.content.SharedPreferences

class SharedPrefHelper {
    companion object {
        fun saveUserId(context: Context, uid: String): Unit {
            var pref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            pref.edit()
                .putString("id", uid).commit()
        }
        fun getUserId(context: Context): String {
            var pref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
          var id=  pref.getString("id","null")
            return id!!
        }

        fun saveOrderId(context: Context, OrderId: String): Unit {
            var pref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            pref.edit()
                .putString("o_id", OrderId).commit()
        }
        fun getOrderId(context: Context): String {
            var pref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            var id=  pref.getString("o_id","")
            return id!!
        }
        fun clearShardPreferences(context: Context) {

            var Sharedpref : SharedPreferences = context.getSharedPreferences("MyPref",
                Context.MODE_PRIVATE)
            val editor = Sharedpref.edit()
            editor.putString("id", "null")
            editor.apply()
        }
        fun clearOrderId(context: Context) {
            var Sharedpref : SharedPreferences = context.getSharedPreferences("MyPref",
                Context.MODE_PRIVATE)
            val editor = Sharedpref.edit()
            editor.putString("o_id", "null")
            editor.apply()
        }
    }
}