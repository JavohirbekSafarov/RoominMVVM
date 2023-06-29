package com.javohirbekcoder.roominmvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.javohirbekcoder.roominmvvm.model.User
import com.javohirbekcoder.roominmvvm.repository.MainRepository


/*
Created by Javohirbek on 29.06.2023 at 13:52
*/
class MainViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var repository: MainRepository

    private var userList = MutableLiveData<MutableList<User>>()

    init {
        repository = MainRepository(application.applicationContext)
        getUsersToList()
    }

    private fun getUsersToList(){
        userList.value = repository.getAllUser().toMutableList()
    }

    fun saveUser(name: String) {
        repository.saveUser(name)
        getUsersToList()
    }

    fun getListOfUser() = userList
}