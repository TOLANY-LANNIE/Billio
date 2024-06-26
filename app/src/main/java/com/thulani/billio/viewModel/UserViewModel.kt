package com.thulani.billio.viewModel

import android.util.Patterns
import androidx.lifecycle.*
import com.thulani.billio.data.entities.User
import com.thulani.billio.data.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository)
    : ViewModel(){
        fun upsert(user: User)= CoroutineScope(Dispatchers.IO).launch {
            repository.upsert(user)
        }
        fun delete(user: User)= CoroutineScope(Dispatchers.IO).launch {
        repository.delete(user)
        }

}