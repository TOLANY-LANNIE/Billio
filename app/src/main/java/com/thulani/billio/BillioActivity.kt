package com.thulani.billio

import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
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

        val bottomNavigation = R.id.bottomNav
        //fragments call
        val home = HomeFragment()
        val calendar =CalendarFragment()
        val balance =BalanceFragment()
        val report = ReportFragment()
        val profile = ProfileFragment()

        replaceFragment(home)
        NavigationBarView.OnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    // Respond to navigation item 1 click
                    true
                }
                R.id.calendar -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.balance -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.report -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.profile -> {
                    // Respond to navigation item 2 click
                    true
                }
                else -> false
            }
        }


    }
    private fun replaceFragment(fragment: Fragment){
        val transaction =supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container_fragment,fragment)
        transaction.commit()

    }
}