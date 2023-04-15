package com.thulani.billio.data.repository

import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.dao.UserDao
import com.thulani.billio.data.entities.User

class UserRepository(
    private val database:BillioDB
    ) {
    suspend fun upsert(user: User) = database.getUserDao().upsert(user)

    suspend fun delete(user: User) = database.getUserDao().delete(user)

    fun getAllUsers() = database.getUserDao().getAll()

    fun login(userEmail: String, userPassword: String) =
        database.getUserDao().login(userEmail, userPassword)
}
