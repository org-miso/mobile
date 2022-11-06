package com.vinyls.mobile.repository.impl

import com.vinyls.mobile.dto.AlbumDTO
import retrofit2.Response
import retrofit2.http.GET

interface VinylsAlbumsAPI {

    @GET("/albums")
    suspend fun getAllAlbums(): Response<List<AlbumDTO>>

}