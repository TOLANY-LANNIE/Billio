package com.thulani.billio.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thulani.billio.data.dao.UserDao
import com.thulani.billio.data.entities.User


@Database(
    entities = [User::class],
    version = 1
)
abstract class BillioDB :RoomDatabase(){

    abstract fun getUserDao(): UserDao

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