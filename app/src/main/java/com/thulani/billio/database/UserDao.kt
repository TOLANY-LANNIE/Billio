package com.thulani.billio.database

import androidx.room.*
import com.thulani.billio.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users_table")
    fun getAll(): List<User>

    @Query("SELECT * FROM users_table WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM users_table WHERE name LIKE :first AND " +
            "surname LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Query("SELECT * FROM users_table WHERE email LIKE :userEmail")
    fun getEmail(userEmail: String): User

    @Insert
    fun insertUser(vararg user: User)

    @Delete
    fun delete(user: User)

    @Delete
    fun deleteUsers(vararg users: User)

    @Update
    fun updateUsers(vararg users: User)

}