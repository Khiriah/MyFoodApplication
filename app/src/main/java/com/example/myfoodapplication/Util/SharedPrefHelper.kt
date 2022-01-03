package com.example.myfoodapplication.Util

import android.content.Context

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
    }
}