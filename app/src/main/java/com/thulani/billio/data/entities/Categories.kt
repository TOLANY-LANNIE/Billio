package com.thulani.billio.data.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories_table")
data class Categories(
    @PrimaryKey @ColumnInfo(name ="cid")val id: Int,
    @NonNull @ColumnInfo(name = "category_name") val name: String,
    @NonNull @ColumnInfo(name = "uEmail") val uEmail: String
)