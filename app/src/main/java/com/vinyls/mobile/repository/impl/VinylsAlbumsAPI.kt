package com.vinyls.mobile.repository.impl

import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.dto.TrackDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface VinylsAlbumsAPI {

    @GET("/albums")
    suspend fun getAllAlbums(): Response<List<AlbumDTO>>

    @POST("/albums")
    suspend fun saveAlbum(@Body albumDTO: AlbumDTO): AlbumDTO

    @POST("/albums/{albumId}/tracks")
    suspend fun saveTrackToAlbum(@Path("albumId") albumId: Int, @Body trackDTO: TrackDTO): TrackDTO

}