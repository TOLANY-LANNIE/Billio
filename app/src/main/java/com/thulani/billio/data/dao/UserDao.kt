package com.thulani.billio.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.thulani.billio.data.entities.User


@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users_table ORDER BY uid DESC")
    fun getAll(): LiveData<List<User>>

    /*@Query("SELECT * FROM users_table" +
            " WHERE email LIKE:userEmail " +
            "AND password LIKE:userPassword")
    fun login(userEmail: String,userPassword:String): User?*/

    @Query("SELECT * FROM users_table WHERE email = :username AND password = :password")
    fun login(username: String, password: String): User?
}