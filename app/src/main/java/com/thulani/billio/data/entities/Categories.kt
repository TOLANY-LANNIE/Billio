package com.thulani.billio.data.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories_table")
data class Categories(
    @NonNull @ColumnInfo(name = "category_name") var name: String,
    @NonNull @ColumnInfo(name = "userID") var userID:Int,
    @NonNull @ColumnInfo(name ="amount") var amount:Double
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="cid")
    var cid: Int?=null
}