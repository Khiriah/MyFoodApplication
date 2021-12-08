package com.example.myfoodapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myfoodapplication.Fragment.CartFragment
import com.example.myfoodapplication.Fragment.HomeFragment
import com.example.myfoodapplication.Fragment.MoreFragment

class FragmentAdapter (activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0-> return HomeFragment()
            1-> return CartFragment()
            2-> return MoreFragment()
        }

        return HomeFragment()
    }
}