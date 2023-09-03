package com.thulani.billio.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.thulani.billio.data.entities.Transactions

import com.thulani.billio.data.entities.User


@Dao
interface TransactionUserDao {
    @Query("SELECT * FROM users_table "+
            "JOIN transaction_table ON users_table.uid = transaction_table.user_id " +
            "WHERE users_table.uid LIKE :userID")
    fun loadUserAndTransactionNames(userID:Int): Map<User, List<Transactions>>
}