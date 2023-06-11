package com.thulani.billio

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.thulani.billio.databinding.ActivityBillioBinding
import com.thulani.billio.fragments.balance.BalanceFragment
import com.thulani.billio.fragments.calendar.CalendarFragment
import com.thulani.billio.fragments.home.HomeFragment
import com.thulani.billio.fragments.profile.ProfileFragment
import com.thulani.billio.fragments.reports.ReportFragment


class BillioActivity : AppCompatActivity() {

    private lateinit var binding:ActivityBillioBinding

    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityBillioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNav)
        //fragments call
        val home = HomeFragment()
        val calendar =CalendarFragment()
        val balance =BalanceFragment()
        val report = ReportFragment()
        val profile = ProfileFragment()

        replaceFragment(home)
        bottomNavigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.home -> replaceFragment(home)
                R.id.calendar -> replaceFragment(calendar)
                R.id.balance -> replaceFragment(balance)
                R.id.report -> replaceFragment(report)
                R.id.menu -> replaceFragment(profile)

            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        val transaction =supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container_fragment,fragment)
        transaction.commit()

    }
}