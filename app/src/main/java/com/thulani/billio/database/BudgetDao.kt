package com.thulani.billio.database

import androidx.room.*
import com.thulani.billio.entities.Bills
import com.thulani.billio.entities.Budget

@Dao
interface BudgetDao {
    @Query("SELECT * FROM budget_table")
    fun getAll(): List<Budget>

    @Query("SELECT * FROM budget_table WHERE bgid IN (:budgetIds)")
    fun loadAllByIds(budgetIds: IntArray): List<Bills>

    @Insert
    fun insertAll(vararg budget: Budget)

    @Delete
    fun delete(budget: Budget)

    @Delete
    fun deleteBudget(vararg budget: Budget)

    @Update
    fun updateBudget(vararg budget: Budget)

}