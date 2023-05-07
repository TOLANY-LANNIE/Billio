package com.thulani.billio.data.dao

import androidx.room.*
import com.thulani.billio.data.entities.Bills
import com.thulani.billio.data.entities.Categories

@Dao
interface CategoriesDao {
    @Query("SELECT * FROM categories_table")
    fun getAll(): List<Categories>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(vararg category: Categories)

    @Delete
    fun delete(categories: Categories)

}