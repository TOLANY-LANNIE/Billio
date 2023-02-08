package com.thulani.billio.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "budget_table")
data class Budget(
    @PrimaryKey @ColumnInfo(name ="bgid")val id: Int,
    @NonNull @ColumnInfo(name = "budget_total") val name: String,
    @NonNull @ColumnInfo(name = "budget_remaining") val amount: Double,
    @NonNull @ColumnInfo(name = "budget_spent") val date: Date,
    @NonNull @ColumnInfo(name = "user_id") val uid: String
)