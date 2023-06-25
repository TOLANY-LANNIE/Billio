package com.thulani.billio.fragments.transactions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.thulani.billio.data.repository.TransactionRepository
import com.thulani.billio.fragments.categories.CategoriesViewModel

class TransactionViewModelFactory(
    private val repository:TransactionRepository
):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return TransactionViewModel(repository) as T
    }
}