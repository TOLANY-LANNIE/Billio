package com.thulani.billio.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.thulani.billio.data.entities.User


@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun upsert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM users_table")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM users_table" +
            " WHERE email LIKE:userEmail " +
            "AND password LIKE:userPassword")
    fun login(userEmail: String,userPassword:String): User



}