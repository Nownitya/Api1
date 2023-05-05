package com.insurfin.api1.ui.api6.data.remote

import com.insurfin.api1.ui.api6.data.api.GithubApiService
import com.insurfin.api1.ui.api6.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()
//        .client(OkHttpClient.Builder().build())
//        .build().create(GithubApiService::class.java)


//    val apiService = retrofitBuilder.create(GithubApiService::class.java)
    val apiUser: GithubApiService by lazy {
        retrofitBuilder.create(GithubApiService::class.java)
}
}