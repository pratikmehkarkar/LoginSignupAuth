package com.example.loginsignupauth.data.network

import com.example.loginsignupauth.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource{
    companion object{
        private const val BASE_URL = "https://apix.simplifiedcoding.in/api/"
    }

    fun<Api> buildApi(api: Class<Api>, authToken: String? = null) : Api
    {
        //we will pass our retrofit client i.e interface
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder()
                .addInterceptor{ chain ->
                    chain.proceed(chain.request().newBuilder().also {
                        it.addHeader("Authorization","Bearer $authToken")
                    }.build())
                }.also {client ->
                if (BuildConfig.DEBUG) {
                    val logging = HttpLoggingInterceptor()
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(logging)
                }
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}