package com.vinyls.mobile.repository.impl

import android.util.Log
import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.dto.TrackDTO
import com.vinyls.mobile.repository.AlbumRepository
import com.vinyls.mobile.repository.util.RetrofitHelper

class AlbumRepositoryImpl : AlbumRepository {

    private val retrofit = RetrofitHelper.getRetrofit()

    override suspend fun getAll(): List<AlbumDTO> {
        var response = retrofit.create(VinylsAlbumsAPI :: class.java).getAllAlbums()
        return response.body() ?: emptyList()
    }

    override fun getOneById(id: Int): AlbumDTO {
        TODO("Not yet implemented")
    }

    override suspend fun saveAlbum(album: AlbumDTO): AlbumDTO? {
        var response = retrofit.create(VinylsAlbumsAPI :: class.java).saveAlbum(album)
        Log.i("INFO HELLO", response.toString())
        return response
    }

    override suspend fun saveTrack(albumId: Int, track: TrackDTO): TrackDTO? {
        var response = retrofit.create(VinylsAlbumsAPI :: class.java).saveTrackToAlbum(albumId, track)
        Log.i("INFO HELLO X 2", response.toString())
        return response
    }

}
