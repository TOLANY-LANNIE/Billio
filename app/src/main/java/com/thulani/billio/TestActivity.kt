package com.thulani.billio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.thulani.billio.adapters.UserItemAdapter
import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.entities.User
import com.thulani.billio.data.repository.UserRepository
import com.thulani.billio.databinding.ActivityTestBinding
import com.thulani.billio.fragments.auth.UserViewModel
import com.thulani.billio.fragments.auth.UserViewModelFactory
import com.thulani.billio.util.AddDialogue


class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityTestBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val database = BillioDB.invoke(this)
        val repository = UserRepository(database)
        val factory = UserViewModelFactory(repository )
        val viewModel = ViewModelProvider(this,factory)[UserViewModel::class.java]

        val userItemAdapter = UserItemAdapter(listOf(),viewModel)


        bind.usersListRV.layoutManager = LinearLayoutManager(this)
        bind.usersListRV.adapter = userItemAdapter

        viewModel.getAlluser().observe(this, Observer {
            userItemAdapter.users =it
            userItemAdapter.notifyDataSetChanged()
        })

        bind.fab.setOnClickListener{
            TestUserDialogue(this,
            object:AddDialogue{
                override fun addButtonClicked(user: User) {
                    viewModel.upsert(user)
                }

            }).show()
        }
    }
}