package com.example.loginsignupauth.data.repository

import com.example.loginsignupauth.data.UserPreferences
import com.example.loginsignupauth.data.network.AuthApi
import com.example.loginsignupauth.data.network.UserApi

class UserRepository(private val api: UserApi
                     ) : BaseRepository()
{
    suspend fun getUser() = safeApiCall {
        api.getUser()
    }


}