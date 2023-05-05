package com.insurfin.api1.ui.api6.data.api

import com.insurfin.api1.ui.api6.model.GithubUserListItem
import retrofit2.Call
import retrofit2.http.GET

interface GithubApiService {

    @GET("users")
    fun getUserList(): Call<List<GithubUserListItem>>


//    suspend fun getUserList():Call<List<GithubUserListItem>>
}