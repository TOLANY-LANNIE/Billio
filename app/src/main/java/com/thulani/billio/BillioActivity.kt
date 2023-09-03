package com.thulani.billio

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.thulani.billio.databinding.ActivityBillioBinding
import com.thulani.billio.fragments.balance.BalanceFragment
import com.thulani.billio.fragments.bills.BillsFragment
import com.thulani.billio.fragments.calendar.CalendarFragment
import com.thulani.billio.fragments.categories.CategoriesFragment
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
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        //tool bar
        val toolbar = findViewById<Toolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNav)
        //fragments call
        val home = HomeFragment()
        val calendar =CalendarFragment()
        val balance =BalanceFragment()
        val report = ReportFragment()
        val profile = ProfileFragment()
        //val category = CategoriesFragment()
        val bills = BillsFragment()
        replaceFragment(bills)
        bottomNavigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
               // R.id.home -> replaceFragment(category)
                R.id.calendar -> replaceFragment(bills)
                R.id.balance -> replaceFragment(balance)
                R.id.report -> replaceFragment(report)
                R.id.menu -> replaceFragment(profile)

            }
            true
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction =supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container_fragment,fragment)
        transaction.commit()

    }
}