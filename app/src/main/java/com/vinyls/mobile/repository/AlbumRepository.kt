package com.vinyls.mobile.repository

import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.dto.TrackDTO

interface AlbumRepository {

    suspend fun getAll(): List<AlbumDTO>
    suspend fun getOneById(id: Int): AlbumDTO?
    suspend fun saveAlbum(album: AlbumDTO): AlbumDTO?
    suspend fun saveTrack(albumId: Int, track: TrackDTO): TrackDTO?

}