package com.example.myfoodapplication.Util

import android.content.Context

class ShardPrefHelper {
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
    }
}