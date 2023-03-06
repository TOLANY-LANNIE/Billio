package com.thulani.billio.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class User(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "surname") var surname: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "password") var password: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="uid")
    var uid: Int?=null
}
