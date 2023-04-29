package com.thulani.billio.fragments.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.thulani.billio.data.entities.User
import com.thulani.billio.data.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository
):ViewModel() {
    var userDetails:User? = null
    val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun upsert(user: User) = coroutineScope.launch {
        repository.upsert(user)
    }

    fun delete(user: User) = coroutineScope.launch {
        repository.delete(user)
    }
    fun getAlluser() = repository.getAllUsers()

    fun login(username:String,password:String){

        coroutineScope.launch {
            val user = repository.login(username,password)
            userDetails =user
        }
    }
}