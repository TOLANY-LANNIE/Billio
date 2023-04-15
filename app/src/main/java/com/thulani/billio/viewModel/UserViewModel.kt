package com.thulani.billio.viewModel

import android.util.Patterns
import androidx.lifecycle.*
import com.thulani.billio.data.entities.User
import com.thulani.billio.data.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository)
    : ViewModel(){
        fun upsert(user: User)= CoroutineScope(Dispatchers.Main).launch {
            repository.upsert(user)
        }
        fun delete(user: User)= CoroutineScope(Dispatchers.Main).launch {
        repository.delete(user)
        }
        fun login(username:String,password:String):User? = repository.login(username,password)

}