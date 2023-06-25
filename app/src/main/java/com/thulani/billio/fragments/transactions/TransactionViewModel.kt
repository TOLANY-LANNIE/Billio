package com.thulani.billio.fragments.transactions

import androidx.lifecycle.ViewModel
import com.thulani.billio.data.entities.Transactions
import com.thulani.billio.data.repository.TransactionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TransactionViewModel(
    private val repository: TransactionRepository
):ViewModel() {
    val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun upsert(transactions: Transactions) =coroutineScope.launch {
        repository.upsert(transactions)
    }

    fun delete(transactions: Transactions)=coroutineScope.launch {
        repository.delete(transactions)
    }

    fun getAllTransactions() =repository.getAllTransactions()

    fun getAllTransactionsByCategory()=repository.getAllTransactionsByCategory()

    fun getAllTransactionsByUser(userID:Int)=coroutineScope.launch {
        repository.getAllTransactionByUser(userID)
    }

    fun searchTransaction(transactionName:String) =coroutineScope.launch {
        repository.searchTransactions(transactionName)
    }
}