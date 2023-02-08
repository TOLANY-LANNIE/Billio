package com.thulani.billio.database

import androidx.room.*
import com.thulani.billio.entities.Bills
import com.thulani.billio.entities.User

@Dao
interface BillsDao {
    @Query("SELECT * FROM bills_table")
    fun getAll(): List<Bills>

    @Query("SELECT * FROM bills_table WHERE uid IN (:billsIds)")
    fun loadAllByIds(billsIds: IntArray): List<Bills>

    @Insert
    fun insertAll(vararg bills: Bills)

    @Delete
    fun delete(bills: Bills)

    @Delete
    fun deleteBills(vararg bills: Bills)

    @Update
    fun updateBills(vararg bills: Bills)

}