package com.thulani.billio.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thulani.billio.data.dao.CategoriesDao
import com.thulani.billio.data.dao.UserDao
import com.thulani.billio.data.entities.Categories
import com.thulani.billio.data.entities.User


@Database(
    entities = [User::class,Categories::class],
    version = 2
)
abstract class BillioDB :RoomDatabase(){

    //users
    abstract fun getUserDao(): UserDao

    //categories
    abstract fun getCategoriesDao():CategoriesDao


    companion object {
        @Volatile
        private var instance: BillioDB? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: createDatabase(context).also { instance=it }
        }
        private fun createDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,
           BillioDB::class.java,
            "billiodb.db")
                .build()
    }
}