package com.thulani.billio.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "categories_table")
data class Categories(
    @PrimaryKey @ColumnInfo(name ="cid")val id: Int,
    @NonNull @ColumnInfo(name = "category_name") val name: String,
    @NonNull @ColumnInfo(name = "category_budget") val amount: Double,
    @NonNull @ColumnInfo(name = "user_id") val uid: String
)