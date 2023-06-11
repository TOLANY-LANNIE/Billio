package com.thulani.billio.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.thulani.billio.data.dao.*
import com.thulani.billio.data.entities.Bills
import com.thulani.billio.data.entities.Categories
import com.thulani.billio.data.entities.Transactions
import com.thulani.billio.data.entities.User
import com.thulani.billio.util.Converters


@Database(
    entities = [User::class,Categories::class,Bills::class,Transactions::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(Converters::class)

abstract class BillioDB :RoomDatabase(){

    //1.users
    abstract fun getUserDao(): UserDao

    //2.categories
    abstract fun getCategoriesDao():CategoriesDao

    //3.bills
    abstract fun getBillsDao():BillsDao

    //4.transactions
    abstract fun getTransactionsDao():TransactionsDao

    //5.transaction-user intermediate dao
    abstract fun getTransUserDao():TransactionUserDao

    //6.transaction-category intermediate dao
    abstract fun getTansCategoryDao():TransactionCategoryDao


    //7.bill-user intermediate dao
    abstract fun getBillUserDao():BillUserDao

    //8.bill-category intermediate dao
    abstract fun getBillCategoryDao():BillCategoryDao

    //9.user-category intermediate dao
    abstract fun getUserCategoryDao():CategoryUserDao

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
                .fallbackToDestructiveMigration()
                .build()
    }
}