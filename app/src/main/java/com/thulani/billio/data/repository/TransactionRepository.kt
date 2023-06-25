package com.thulani.billio.data.repository

import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.entities.Transactions

class TransactionRepository(
    private val database:BillioDB
) {
    suspend fun upsert(transaction: Transactions) =
        database.getTransactionsDao().upsert(transaction)

    suspend fun delete(transaction: Transactions)=
        database.getTransactionsDao().delete(transaction)

    fun getAllTransactions()=
        database.getTransactionsDao().getAll()

    fun getAllTransactionsByCategory()=
        database.getTansCategoryDao().loadTransactionByCategoryNames()

    suspend fun getAllTransactionByUser(userID:Int)=
        database.getTransUserDao().loadUserAndTransactionNames(userID)

   suspend fun searchTransactions(transactionName:String):Transactions?{
        return database.getTransactionsDao().searchTransaction(transactionName)
    }
}