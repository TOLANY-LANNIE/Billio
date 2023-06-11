package com.thulani.billio.data.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "transaction_table")
data class Transactions(
    @NonNull @ColumnInfo(name = "transaction_name") var name: String,
    @NonNull @ColumnInfo(name = "categoryID") var categoryID:Int,
    @NonNull @ColumnInfo(name = "amount") var amount: Double,
    @NonNull @ColumnInfo(name = "date") var date: Date,
    @NonNull @ColumnInfo(name = "type") var type: String,
    @NonNull @ColumnInfo(name = "user_id") var userID: Int
)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="tid")
    var tid: Int?=null
}