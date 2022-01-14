package com.example.loginsignupauth.ui.base

import androidx.lifecycle.ViewModel
import com.example.loginsignupauth.data.network.UserApi
import com.example.loginsignupauth.data.repository.BaseRepository
import com.example.loginsignupauth.data.repository.UserRepository

abstract class BaseViewModel(
    private val repository: BaseRepository
):ViewModel() {
    suspend fun logout(api: UserApi) = repository.logout(api)
}