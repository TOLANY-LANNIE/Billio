package com.thulani.billio.fragments.bills

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.thulani.billio.data.repository.BillRepository
import com.thulani.billio.fragments.categories.CategoriesViewModel


@Suppress("UNCHECKED_CAST")
class BillsViewModelFactory(
    private val repository: BillRepository
):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return BillsViewModel(repository) as T
    }
}