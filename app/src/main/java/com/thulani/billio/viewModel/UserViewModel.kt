package com.thulani.billio.viewModel

import android.util.Patterns
import androidx.lifecycle.*
import com.thulani.billio.data.entities.User
import com.thulani.billio.data.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository): ViewModel(){
    private var isUpdateOrDelete = false
    private lateinit var userToUpdateOrDelete: User
    val inputName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()
    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun initUpdateAndDelete(user: User) {
        inputName.value = user.name
        inputEmail.value = user.email
        isUpdateOrDelete = true
        userToUpdateOrDelete = user
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }

    fun saveOrUpdate() {
        if (inputName.value == null) {
            statusMessage.value = Event("Please enter subscriber's name")
        } else if (inputEmail.value == null) {
            statusMessage.value = Event("Please enter subscriber's email")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.value!!).matches()) {
            statusMessage.value = Event("Please enter a correct email address")
        } else {
            if (isUpdateOrDelete) {
                userToUpdateOrDelete.name = inputName.value!!
                userToUpdateOrDelete.email = inputEmail.value!!
                updateUser(userToUpdateOrDelete)
            } else {
                val name = inputName.value!!
                val email = inputEmail.value!!
                insertUser(User(0, name, email))
                inputName.value = ""
                inputEmail.value = ""
            }
        }
    }

    private fun insertUser(user: User) = viewModelScope.launch {
        val newRowId = repository.insert(user)
        if (newRowId > -1) {
            statusMessage.value = Event("User Inserted Successfully $newRowId")
        } else {
            statusMessage.value = Event("Error Occurred")
        }
    }

    private fun updateUser(user: User) =  viewModelScope.launch {
        val numOfRows = repository.update(user)
        if(numOfRows>0){
            inputName.value =""
            inputEmail.value=""
            isUpdateOrDelete = false
            saveOrUpdateButtonText.value ="Save"
            clearAllOrDeleteButtonText.value ="Clear ALl"
            statusMessage.value =Event("$numOfRows  Rows update Successfully")
        } else{
            statusMessage.value =Event("$numOfRows  Error Occurred")
        }
    }

    fun getSavedUsers() = liveData<List<User>> {
        repository.user.collect{
            emit(it)
        }
    }

}