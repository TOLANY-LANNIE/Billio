package com.thulani.billio.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thulani.billio.data.entities.Transactions

@Dao
interface TransactionsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(transaction: Transactions)

    @Delete
    fun delete(transaction: Transactions)

    @Query("SELECT * FROM transaction_table ORDER BY tid DESC")
    fun getAll():LiveData<List<Transactions>>

    @Query("SELECT * FROM transaction_table WHERE transaction_name =:transactionName")
    fun searchTransaction(transactionName:String)
}