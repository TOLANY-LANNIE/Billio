package com.thulani.billio.data.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "income_table")
data class Income(
    @NonNull @ColumnInfo(name = "income_description") var name: String,
    @NonNull @ColumnInfo(name = "amount") var amount: Double,
    @NonNull @ColumnInfo(name = "date") var date: Date,
    @NonNull @ColumnInfo(name = "user_id") var userID: Int
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="iid")
    var iid: Int?=null
}