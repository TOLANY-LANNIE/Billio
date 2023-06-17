package com.thulani.billio.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.thulani.billio.data.entities.Bills
import com.thulani.billio.data.entities.Categories

@Dao
interface CategoriesDao {
    @Query("SELECT * FROM categories_table")
    fun getAll(): LiveData<List<Categories>>

    @Query("SELECT * FROM categories_table WHERE category_name =:catName")
    fun getSelectedCat(catName:String):Categories?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(vararg category: Categories)

    @Delete
    fun delete(categories: Categories)

}