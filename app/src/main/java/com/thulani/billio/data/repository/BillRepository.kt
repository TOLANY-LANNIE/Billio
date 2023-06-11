package com.thulani.billio.data.repository

import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.entities.Bills

class BillRepository(
    private val database: BillioDB
){
    suspend fun upsert(bill: Bills)=
        database.getBillsDao().upsert(bill)

    suspend fun delete(bill: Bills)=
        database.getBillsDao().delete(bill)

    fun getAllBills()=
        database.getBillsDao().getAll()

    fun getAllBillsByCategory()=
        database.getBillCategoryDao().loadBillsByCategoryNames()

    fun getAllBillsByUser()=
        database.getBillUserDao().loadUserAndBillsNames()

    suspend fun searchBills(bill:String):Bills?{
        return database.getBillsDao().searchBill(bill)
    }

}