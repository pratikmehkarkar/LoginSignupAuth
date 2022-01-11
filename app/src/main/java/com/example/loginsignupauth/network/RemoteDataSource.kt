package com.example.loginsignupauth.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RemoteDataSource{
    companion object{
        private const val BASE_URL = "https://apix.simplifiedcoding.in/api/"
    }

    fun<Api> buildApi(api: Class<Api>) : Api
    {
        //we will pass our retrofit client i.e interface
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}