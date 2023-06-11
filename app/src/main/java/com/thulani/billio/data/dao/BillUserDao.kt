package com.thulani.billio.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.thulani.billio.data.entities.Bills
import com.thulani.billio.data.entities.Categories

import com.thulani.billio.data.entities.User

@Dao
interface BillUserDao {
    @Query("SELECT * FROM users_table "+
            "JOIN bills_table ON users_table.uid = bills_table.user_id")
    fun loadUserAndBillsNames(): Map<User, List<Bills>>

    @Query("SELECT * FROM bills_table "+
            "JOIN categories_table ON bills_table.user_id= categories_table.userID")
    fun loadBillByCategoryNames(): Map<Bills, List<Categories>>

}