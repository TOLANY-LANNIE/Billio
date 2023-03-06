package com.thulani.billio.data.dao

import androidx.room.*
import com.thulani.billio.data.entities.Bills
import com.thulani.billio.data.entities.Categories

@Dao
interface CategoriesDao {
    @Query("SELECT * FROM categories_table")
    fun getAll(): List<Categories>

    @Query("SELECT * FROM categories_table WHERE cid IN (:categoryId)")
    fun loadAllByIds(categoryId: IntArray): List<Bills>

    @Insert
    fun insertAll(vararg category: Categories)

    @Delete
    fun delete(categories: Categories)

    @Delete
    fun deleteCategory(vararg categories: Categories)

    @Update
    fun updateCategory(vararg categories: Categories)

}