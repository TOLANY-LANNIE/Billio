package com.thulani.billio.database

import androidx.room.*
import com.thulani.billio.entities.Bills
import com.thulani.billio.entities.Income

@Dao
interface IncomeDao {
    @Query("SELECT * FROM income_table")
    fun getAll(): List<Income>

    @Insert
    fun insertAll(vararg income: Income)

    @Delete
    fun delete(income: Income)

    @Delete
    fun deleteIncome(vararg income: Income)

    @Update
    fun updateIncome(vararg income: Income)

}