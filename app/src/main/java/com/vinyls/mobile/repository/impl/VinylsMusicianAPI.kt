package com.vinyls.mobile.repository.impl

import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.model.Musician
import retrofit2.Response
import retrofit2.http.GET

interface VinylsMusicianAPI {

    @GET("/musicians")
    suspend fun getAllMusicians(): Response<List<Musician>>

}