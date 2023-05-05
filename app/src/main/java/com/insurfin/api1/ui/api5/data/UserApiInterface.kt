package com.insurfin.api1.ui.api5.data

import com.insurfin.api1.ui.api5.model.UserDetailsList
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call


interface  UserApiInterface {

    @GET("users")
    fun getUserDetailList(
        @Query("page") page: Int ,
        @Query("per_page") perPage: Int
    ): Call<UserDetailsList>

}