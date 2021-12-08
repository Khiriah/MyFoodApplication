package com.example.myfoodapplication.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myfoodapplication.More.HelpActivity
import com.example.myfoodapplication.More.InvoicesActivity
import com.example.myfoodapplication.More.ProfileActivity
import com.example.myfoodapplication.More.SettingActivity
import com.example.myfoodapplication.R
import com.example.myfoodapplication.ui.view.DetailsActivity


class MoreFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v=inflater.inflate(R.layout.fragment_more, container, false)
        var textViewSetting=v.findViewById<TextView>(R.id.textViewSetting)
        var textViewHelp=v.findViewById<TextView>(R.id.textViewHelp)
        var textViewVouchers=v.findViewById<TextView>(R.id.textViewVouchers)
        var textViewProfile=v.findViewById<TextView>(R.id.textViewProfile)
        textViewSetting.setOnClickListener {
            var intent = Intent(context, SettingActivity::class.java)
           startActivity(intent)
        }
        textViewHelp.setOnClickListener {
            var intent = Intent(context, HelpActivity::class.java)
            startActivity(intent)
        }
        textViewVouchers.setOnClickListener {
            var intent = Intent(context, InvoicesActivity::class.java)
            startActivity(intent)
        }
        textViewProfile.setOnClickListener {
            var intent = Intent(context, ProfileActivity::class.java)
            startActivity(intent)
        }
        return v
    }


    }
