package com.thulani.billio.fragments.categories

import androidx.lifecycle.ViewModel
import com.thulani.billio.data.entities.Categories
import com.thulani.billio.data.repository.CategoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val repository: CategoryRepository
):ViewModel(){
    val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun upsert(category: Categories) = coroutineScope.launch {
        repository.upsert(category)
    }
    fun delete(category: Categories) = coroutineScope.launch {
        repository.delete(category)
    }

    fun getAllCategories() = repository.getAllCategories()

    fun selectedCategory(categoryName:String){
        coroutineScope.launch {
            val category = repository.selectedCategory(categoryName)
        }
    }
}