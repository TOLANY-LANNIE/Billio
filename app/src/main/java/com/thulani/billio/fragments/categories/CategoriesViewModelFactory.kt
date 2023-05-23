package com.thulani.billio.fragments.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.thulani.billio.data.repository.CategoryRepository
import com.thulani.billio.data.repository.UserRepository
import com.thulani.billio.fragments.auth.UserViewModel

@Suppress("UNCHECKED_CAST")
class CategoriesViewModelFactory(
    private val repository: CategoryRepository
):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return CategoriesViewModel(repository) as T
    }
}