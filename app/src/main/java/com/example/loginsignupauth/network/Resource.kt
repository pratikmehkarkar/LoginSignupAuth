package com.example.loginsignupauth.network

import okhttp3.ResponseBody
import java.lang.Error

//This class will handle all kind of api responses, like success or failure of api
sealed class Resource<out T>{

    data class Success<out T>(val value: T) : Resource<T>()

    data class Failure(
        val isNetworkError: Boolean?,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ) : Resource<Nothing>()
}
