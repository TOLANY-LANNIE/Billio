package com.thulani.billio.data.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "bills_table")
data class Bills(
    @NonNull @ColumnInfo(name = "bill_description") var name: String,
    @NonNull @ColumnInfo(name = "amount") var amount: Double,
    @NonNull @ColumnInfo(name = "due_date") var date: Date,
    @NonNull @ColumnInfo(name = "status") var status: String,
    @NonNull @ColumnInfo(name = "categoryID") var categoryID: Int,
    @NonNull @ColumnInfo(name = "user_id") var uid: Int
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="bid")
    var bid: Int?=null
}
