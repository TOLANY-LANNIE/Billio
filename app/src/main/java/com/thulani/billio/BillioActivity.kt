package com.thulani.billio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.thulani.billio.fragments.balance.BalanceFragment
import com.thulani.billio.fragments.calendar.CalendarFragment
import com.thulani.billio.fragments.home.HomeFragment
import com.thulani.billio.fragments.profile.ProfileFragment
import com.thulani.billio.fragments.reports.ReportFragment


class BillioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_billio)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNav)
        //fragments call
        val home = HomeFragment()
        val calendar =CalendarFragment()
        val balance =BalanceFragment()
        val report = ReportFragment()
        val profile = ProfileFragment()

        replaceFragment(profile)
        NavigationBarView.OnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    // Respond to navigation item 1 click
                    replaceFragment(home)
                    true
                }
                R.id.calendar -> {
                    // Respond to navigation item 2 click
                    replaceFragment(calendar)
                    true
                }
                R.id.balance -> {
                    // Respond to navigation item 2 click
                    replaceFragment(balance)
                    true
                }
                R.id.report -> {
                    replaceFragment(report)
                    // Respond to navigation item 2 click
                    true
                }
                R.id.profile -> {
                    // Respond to navigation item 2 click
                    replaceFragment(profile)
                    true
                }
                else -> false
            }
        }

        bottomNavigation.setOnItemReselectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    // Respond to navigation item 1 click
                    replaceFragment(home)
                }
                R.id.calendar -> {
                    // Respond to navigation item 2 click
                    replaceFragment(calendar)
                }
                R.id.balance -> {
                    // Respond to navigation item 2 click
                    replaceFragment(balance)
                }
                R.id.report -> {
                    replaceFragment(report)
                    // Respond to navigation item 2 click
                }
                R.id.profile -> {
                    // Respond to navigation item 2 click
                    replaceFragment(profile)
                }
            }
        }

    }
    private fun replaceFragment(fragment: Fragment){
        val transaction =supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container_fragment,fragment)
        transaction.commit()

    }
}