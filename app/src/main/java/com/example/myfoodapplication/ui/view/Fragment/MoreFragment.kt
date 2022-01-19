package com.example.myfoodapplication.ui.view.Fragment

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.myfoodapplication.ui.view.More.HelpActivity
import com.example.myfoodapplication.ui.view.More.InvoicesActivity
import com.example.myfoodapplication.ui.view.More.ProfileActivity
import com.example.myfoodapplication.ui.view.More.SettingActivity
import com.example.myfoodapplication.R


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
        var textViewConnectUs=v.findViewById<TextView>(R.id.textViewConnectUs)
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
        textViewConnectUs.setOnClickListener {
            val i = Intent(Intent.ACTION_SEND)
            i.type = "message/Hi CozyMeal"
            i.putExtra(Intent.EXTRA_EMAIL, arrayOf("khairiahalayyafi@gmail.com"))
            i.putExtra(Intent.EXTRA_SUBJECT, "subject of email")
            i.putExtra(Intent.EXTRA_TEXT, "body of email")
            try {
                startActivity(Intent.createChooser(i, "Send mail..."))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(
                    context,
                    "There are no email clients installed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        return v
    }
}
