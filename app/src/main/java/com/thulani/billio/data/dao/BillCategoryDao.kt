package com.thulani.billio.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.thulani.billio.data.entities.Bills
import com.thulani.billio.data.entities.Categories

@Dao
interface BillCategoryDao {
    @Query("SELECT * FROM bills_table "+
            "JOIN categories_table ON bills_table.categoryID = categories_table.cid")
    fun loadBillsByCategoryNames(): Map<Bills, List<Categories>>
}