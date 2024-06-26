package com.thulani.billio.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.thulani.billio.data.entities.Bills

@Dao
interface BillsDao {
    @Query("SELECT * FROM bills_table")
    fun getAll(): LiveData<List<Bills>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(vararg bills: Bills)

    @Delete
    fun delete(bills: Bills)

    @Query("SELECT * FROM bills_table WHERE bill_description =:billName")
    fun searchBill(billName:String):Bills?


    @Query("SELECT * FROM bills_table ORDER BY bid DESC LIMIT 5")
    fun getLastFiveBills():LiveData<List<Bills>>
}