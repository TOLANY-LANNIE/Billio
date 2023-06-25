package com.thulani.billio.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.thulani.billio.data.entities.Categories
import com.thulani.billio.data.entities.User

@Dao
interface CategoryUserDao {
    @Query("SELECT * FROM categories_table "+
            "JOIN users_table ON users_table.uid = categories_table.userId")
    fun loadUserAndCategoryNames(): Map<User, List<Categories>>

}