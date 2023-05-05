package com.insurfin.api1.ui.api2_retrofit.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {

    @GET("albums")
    suspend fun getAlbum(): Response<Album>


}