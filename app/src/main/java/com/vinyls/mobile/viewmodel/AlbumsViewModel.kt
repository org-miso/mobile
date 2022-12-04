package com.vinyls.mobile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.dto.TrackDTO
import com.vinyls.mobile.model.Album
import com.vinyls.mobile.repository.impl.AlbumRepositoryImpl
import com.vinyls.mobile.util.AlbumUtil
import kotlinx.coroutines.launch

class AlbumsViewModel(): ViewModel() {

    private val albumRepository = AlbumRepositoryImpl()

    var albums = MutableLiveData<List<Album?>>()

    fun getAllAlbums() {
        viewModelScope.launch {
            var albumsData: List<AlbumDTO>? = albumRepository.getAll()
            if (!albumsData.isNullOrEmpty()){
                albums.postValue(albumsData!!.asSequence().map { a -> AlbumUtil().DTOtoEntity(a) }.toList())
            }
        }
    }

    fun saveAlbum(album: AlbumDTO){

        viewModelScope.launch {
            albumRepository.saveAlbum(album)
            getAllAlbums()
        }

    }

    fun saveTrack(albumId: Int, trackDTO: TrackDTO){

        viewModelScope.launch {
            val result = albumRepository.saveTrack(albumId, trackDTO)
            getAllAlbums()
        }

    }

}