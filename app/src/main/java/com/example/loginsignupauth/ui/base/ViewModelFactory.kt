package com.example.loginsignupauth.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginsignupauth.data.repository.AuthRepository
import com.example.loginsignupauth.data.repository.BaseRepository
import com.example.loginsignupauth.data.repository.UserRepository
import com.example.loginsignupauth.ui.auth.AuthViewModel
import com.example.loginsignupauth.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory (private val repository: BaseRepository) : ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return when{
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
           modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository as UserRepository) as T
            else -> throw IllegalArgumentException("ViewModel Class Not Found")
        }
    }
}