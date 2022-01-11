package com.example.loginsignupauth.network

import com.example.loginsignupauth.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


//Here we will define the API calls
interface AuthApi
{
    //this function will define the fields for our API
    //this annotation will define the URL end points
    @FormUrlEncoded
    @POST("auth/api")
    suspend fun login(
        @Field("email") email : String,
        @Field("password") password: String
    ):LoginResponse

}