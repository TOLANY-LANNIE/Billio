package com.thulani.billio.fragments.bills

import androidx.lifecycle.ViewModel
import com.thulani.billio.data.entities.Bills
import com.thulani.billio.data.repository.BillRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BillsViewModel(
 private val repository: BillRepository
):ViewModel(){
    private val coroutineScope = CoroutineScope(Dispatchers.IO)


    fun upsert(bills:Bills)= coroutineScope.launch {
        repository.upsert(bills)
    }

    fun delete(bills: Bills) = coroutineScope.launch {
        repository.delete(bills)
    }

    fun getAllBills()=repository.getAllBills()

    fun getAllBillsByCategory()= repository.getAllBillsByCategory()

    fun getAllBillsByUser()= repository.getAllBillsByUser()


    fun searchBills(bills:String) =coroutineScope.launch {
        repository.searchBills(bills)
    }

}