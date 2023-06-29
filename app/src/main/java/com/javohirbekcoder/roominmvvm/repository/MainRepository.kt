package com.javohirbekcoder.roominmvvm.repository

import android.content.Context
import com.javohirbekcoder.roominmvvm.database.UserDAO
import com.javohirbekcoder.roominmvvm.database.UserDatabase
import com.javohirbekcoder.roominmvvm.model.User

/*
Created by Javohirbek on 29.06.2023 at 13:49
*/

class MainRepository(context: Context) {

    private lateinit var dbHelper: UserDatabase
    init {
        dbHelper = UserDatabase.getDatabaseInstance(context)
    }

    fun saveUser(name:String){
        dbHelper.userDao().insert(User(name))
    }

    fun getAllUser():List<User>{
        return dbHelper.userDao().getAll()
    }
}