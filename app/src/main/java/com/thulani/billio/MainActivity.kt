package com.thulani.billio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.thulani.billio.fragments.auth.LoginFragment
import com.thulani.billio.fragments.auth.SignUpFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signUp = SignUpFragment()
        val login = LoginFragment()
        val fragment:Fragment? =
            supportFragmentManager.findFragmentByTag(LoginFragment::class.java.simpleName)
        if(fragment !is LoginFragment ){
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView,login,LoginFragment::class.java.simpleName)
                .commit()
        }

    }
}