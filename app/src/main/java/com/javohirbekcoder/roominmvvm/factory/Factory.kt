package com.javohirbekcoder.roominmvvm.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.javohirbekcoder.roominmvvm.viewModel.MainViewModel


/*
Created by Javohirbek on 29.06.2023 at 13:53
*/
class Factory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(application) as T
        throw IllegalStateException("Illegal Exception")
    }
}