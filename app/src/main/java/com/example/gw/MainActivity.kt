package com.example.gw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // start a fragment
    private lateinit var currentFragment : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // home and dashboard
        // set home fragment as launcher
        supportFragmentManager.beginTransaction().replace(R.id.nav_container,HomeFragment()).commit()
        // now create a menu
        val bottomNav : BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener(bottomListener)
    }

    val bottomListener = BottomNavigationView.OnNavigationItemSelectedListener {
        // switch between ids of menu
        when(it.itemId){
            R.id.home -> {
                currentFragment = HomeFragment()
            }
            R.id.dashboard -> {
                currentFragment = dashboardFragment()
            }
            R.id.profile -> {
                currentFragment = profileFragment()
            }
            R.id.historique -> {
                currentFragment = HistoriqueFragment()
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.nav_container,currentFragment).commit()
        true
    }
}