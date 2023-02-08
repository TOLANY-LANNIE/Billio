package com.thulani.billio.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thulani.billio.entities.User


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class BillioDB :RoomDatabase(){

    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: BillioDB? = null


        fun getInstance(context: Context): BillioDB {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BillioDB::class.java,
                        "billio_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}