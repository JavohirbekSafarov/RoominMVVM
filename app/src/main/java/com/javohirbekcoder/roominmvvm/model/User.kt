package com.javohirbekcoder.roominmvvm.model

import androidx.room.Entity
import androidx.room.PrimaryKey


/*
Created by Javohirbek on 29.06.2023 at 13:36
*/
@Entity
data class User(
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
