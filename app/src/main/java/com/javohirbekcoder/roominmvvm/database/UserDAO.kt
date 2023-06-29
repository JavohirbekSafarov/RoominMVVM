package com.javohirbekcoder.roominmvvm.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.javohirbekcoder.roominmvvm.model.User


/*
Created by Javohirbek on 29.06.2023 at 13:42
*/
@Dao
interface UserDAO {

    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Insert
    fun insert(vararg users: User)

}