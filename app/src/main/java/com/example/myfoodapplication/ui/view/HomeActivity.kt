package com.example.myfoodapplication.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import com.example.myfoodapplication.R
import com.example.myfoodapplication.adapter.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.messaging.FirebaseMessaging

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var viewPager=findViewById<ViewPager2>(R.id.FViewPager)
        var ftabLayout=findViewById<TabLayout>(R.id.FtabLayout)
      viewPager.adapter= FragmentAdapter(this)
     //   viewPager.setPageTransformer(ZoomOutPageTransformer())
        var titles= arrayOf(getString(R.string.home),getString(R.string.cart),getString(R.string.more))
        var icons= arrayOf(R.drawable.ic_baseline_home_24,R.drawable.ic_baseline_add_shopping_cart_24,R.drawable.ic_baseline_more_horiz_24)
        TabLayoutMediator(ftabLayout,viewPager){ tab, position ->
            tab.text= titles[position]
            tab.setIcon(icons[position])

        }.attach()
    }
}



//
//@RequiresApi(21)
//class DepthPageTransformer : ViewPager2.PageTransformer {
//
//    override fun transformPage(view: View, position: Float) {
//        view.apply {
//            val pageWidth = width
//            when {
//                position < -1 -> { // [-Infinity,-1)
//                    // This page is way off-screen to the left.
//                    alpha = 0f
//                }
//                position <= 0 -> { // [-1,0]
//                    // Use the default slide transition when moving to the left page
//                    alpha = 1f
//                    translationX = 0f
//                    translationZ = 0f
//                    scaleX = 1f
//                    scaleY = 1f
//                }
//                position <= 1 -> { // (0,1]
//                    // Fade the page out.
//                    alpha = 1 - position
//
//                    // Counteract the default slide transition
//                    translationX = pageWidth * -position
//                    // Move it behind the left page
//                    translationZ = -1f
//
//                    // Scale the page down (between MIN_SCALE and 1)
//                    val scaleFactor = (MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position)))
//                    scaleX = scaleFactor
//                    scaleY = scaleFactor
//                }
//                else -> { // (1,+Infinity]
//                    // This page is way off-screen to the right.
//                    alpha = 0f
//                }
//            }
//        }
//    }
//}
//
//
//private const val MIN_SCALE = 0.85f
//private const val MIN_ALPHA = 0.5f
//
//class ZoomOutPageTransformer : ViewPager2.PageTransformer {
//
//    override fun transformPage(view: View, position: Float) {
//        view.apply {
//            val pageWidth = width
//            val pageHeight = height
//            when {
//                position < -1 -> { // [-Infinity,-1)
//                    // This page is way off-screen to the left.
//                    alpha = 0f
//                }
//                position <= 1 -> { // [-1,1]
//                    // Modify the default slide transition to shrink the page as well
//                    val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
//                    val vertMargin = pageHeight * (1 - scaleFactor) / 2
//                    val horzMargin = pageWidth * (1 - scaleFactor) / 2
//                    translationX = if (position < 0) {
//                        horzMargin - vertMargin / 2
//                    } else {
//                        horzMargin + vertMargin / 2
//                    }
//
//                    // Scale the page down (between MIN_SCALE and 1)
//                    scaleX = scaleFactor
//                    scaleY = scaleFactor
//
//                    // Fade the page relative to its size.
//                    alpha = (MIN_ALPHA +
//                            (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))
//                }
//                else -> { // (1,+Infinity]
//                    // This page is way off-screen to the right.
//                    alpha = 0f
//                }
//            }
//        }
//    }
//}