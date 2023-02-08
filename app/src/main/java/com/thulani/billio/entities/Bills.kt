package com.thulani.billio.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "bills_table")
data class Bills(
    @PrimaryKey @ColumnInfo(name ="uid")val bid: Int,
    @NonNull @ColumnInfo(name = "bill_name") val name: String,
    @NonNull @ColumnInfo(name = "amount") val amount: Double,
    @NonNull @ColumnInfo(name = "due_date") val date: Date,
    @NonNull @ColumnInfo(name = "status") val status: String,
    @NonNull @ColumnInfo(name = "user_id") val uid: String
)
