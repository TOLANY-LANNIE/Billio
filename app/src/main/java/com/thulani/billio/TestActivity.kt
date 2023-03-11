package com.thulani.billio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.repository.UserRepository
import com.thulani.billio.fragments.auth.UserViewModel
import com.thulani.billio.fragments.auth.UserViewModelFactory


class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val database = BillioDB.invoke(this)
        val repository = UserRepository(database)
        val factory = UserViewModelFactory(repository )
        val viewModel = ViewModelProvider(this,factory)[UserViewModel::class.java]
    }
}