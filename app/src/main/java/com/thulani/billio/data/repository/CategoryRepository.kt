package com.thulani.billio.data.repository

import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.entities.Categories

class CategoryRepository(
    private val database:BillioDB
    ) {

    suspend fun upsert(categories: Categories) = database.getCategoriesDao().upsert(categories)

    suspend fun delete(categories: Categories)= database.getCategoriesDao().delete(categories)

    fun getAllCategories() = database.getCategoriesDao().getAll()

    fun getAllCategoriesByUser()= database.getUserCategoryDao().loadUserAndCategoryNames()


    suspend fun selectedCategory(categoryName:String):Categories?{
        return database.getCategoriesDao().getSelectedCat(categoryName)
    }
}