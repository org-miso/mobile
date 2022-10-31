package com.vinyls.mobile.viewmodel

import androidx.lifecycle.ViewModel
import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.model.Album
import com.vinyls.mobile.repository.AlbumRepository
import com.vinyls.mobile.util.AlbumUtil

class AlbumsViewModel(private val albumRepository: AlbumRepository): ViewModel() {

    var albums: List<Album?> = getAllAlbums()

    fun getAllAlbums(): List<Album?> {
        var albumsData: List<AlbumDTO>? = albumRepository.getAll()
        return albumsData!!.asSequence().map { a -> AlbumUtil().DTOtoEntity(a) }
            .toList()
    }

}