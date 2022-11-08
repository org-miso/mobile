package com.vinyls.mobile.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.model.Album
import com.vinyls.mobile.model.Musician
import com.vinyls.mobile.repository.AlbumRepository
import com.vinyls.mobile.repository.impl.AlbumRepositoryImpl
import com.vinyls.mobile.repository.impl.MusicianRepositoryImpl
import com.vinyls.mobile.util.AlbumUtil
import kotlinx.coroutines.launch

class MusicianViewModel(): ViewModel() {

    private val musicianRepository = MusicianRepositoryImpl()

    var albums = MutableLiveData<List<Musician?>>()

    fun getAllAlbums() {
        viewModelScope.launch {
            var data: List<Musician>? = musicianRepository.getAll()
            if (!data.isNullOrEmpty()){
                Log.i("INFORMATION DEVELOPER", "Resultant: $data")
                albums.postValue(data ?: emptyList())
            }
        }
    }

}