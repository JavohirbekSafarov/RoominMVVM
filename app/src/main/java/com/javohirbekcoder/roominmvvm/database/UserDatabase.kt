package com.javohirbekcoder.roominmvvm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.javohirbekcoder.roominmvvm.model.User


/*
Created by Javohirbek on 29.06.2023 at 13:42
*/
@Database(entities = [User::class], version = 1)
abstract class UserDatabase:RoomDatabase() {
    abstract fun userDao(): UserDAO

    companion object{
        private var INSTANCE : UserDatabase? = null

        fun getDatabaseInstance(context: Context): UserDatabase {
            if (INSTANCE == null){
                INSTANCE = createDatabaseInstance(context)
            }
            return INSTANCE as UserDatabase
        }

        private fun createDatabaseInstance(context: Context) : UserDatabase {
            return Room.databaseBuilder(
                context,
                UserDatabase::class.java,
                "user_database"
            ).allowMainThreadQueries()
                .build()
        }
    }
}
