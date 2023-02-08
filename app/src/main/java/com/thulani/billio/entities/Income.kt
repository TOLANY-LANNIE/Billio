package com.thulani.billio.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "income_table")
data class Income(
    @PrimaryKey @ColumnInfo(name ="uid")val bid: Int,
    @NonNull @ColumnInfo(name = "income_name") val name: String,
    @NonNull @ColumnInfo(name = "amount") val amount: Double,
    @NonNull @ColumnInfo(name = "date") val date: Date,
    @NonNull @ColumnInfo(name = "user_id") val uid: String
)