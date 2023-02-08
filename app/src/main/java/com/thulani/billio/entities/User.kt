package com.thulani.billio.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class User(
    @PrimaryKey @ColumnInfo(name ="uid")val uid: Int,
    @NonNull @ColumnInfo(name = "name") val name: String,
    @NonNull @ColumnInfo(name = "surname") val username: String,
    @NonNull @ColumnInfo(name = "email") val email: String,
    @NonNull @ColumnInfo(name = "password") val password: String
)
