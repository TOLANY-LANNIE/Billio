package com.thulani.billio.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.thulani.billio.data.entities.Categories
import com.thulani.billio.data.entities.Transactions


@Dao
interface TransactionCategoryDao {
    @Query("SELECT * FROM transaction_table "+
            "JOIN categories_table ON transaction_table.categoryID = categories_table.cid")
    fun loadTransactionByCategoryNames(): Map<Transactions, List<Categories>>
}