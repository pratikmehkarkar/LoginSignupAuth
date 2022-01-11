package com.example.loginsignupauth.repository

import com.example.loginsignupauth.network.AuthApi

class AuthRepository(private val api: AuthApi) : BaseRepository(){
    suspend fun login(email: String, password: String) = safeApiCall {
        api.login(email, password)
    }
}