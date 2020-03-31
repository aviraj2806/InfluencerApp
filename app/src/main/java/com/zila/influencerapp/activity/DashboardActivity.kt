package com.zila.influencerapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zila.influencerapp.R
import com.zila.influencerapp.fragment.ProfileFragment
import com.zila.influencerapp.fragment.SubmitVideoFragment
import com.zila.influencerapp.fragment.VideoDetailsFragment

class DashboardActivity : AppCompatActivity(){

    lateinit var bottomNavigation: BottomNavigationView
    lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        bottomNavigation = findViewById(R.id.myNavigation)
        frameLayout = findViewById(R.id.frameLayout)

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,ProfileFragment()).commit()

        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout,ProfileFragment()).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_vdetails -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout,VideoDetailsFragment()).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_vsubmit -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout,SubmitVideoFragment()).commit()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

    }

}
