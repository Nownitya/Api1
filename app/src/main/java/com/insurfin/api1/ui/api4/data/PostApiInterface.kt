package com.insurfin.api1.ui.api4.data


import com.insurfin.api1.ui.api4.model.PostList1Item
import retrofit2.Call
import retrofit2.http.GET


interface PostApiInterface {

    @GET("posts")
    fun getData(): Call<List<PostList1Item>>

}