package com.vinyls.mobile.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinyls.mobile.model.Musician
import com.vinyls.mobile.repository.impl.MusicianRepositoryImpl
import kotlinx.coroutines.launch

class MusicianViewModel(): ViewModel() {

    private val musicianRepository = MusicianRepositoryImpl()

    var albums = MutableLiveData<List<Musician?>>()

    fun getAllAlbums() {
        viewModelScope.launch {
            var data: List<Musician>? = musicianRepository.getAll()
            if (!data.isNullOrEmpty()){
                albums.postValue(data ?: emptyList())
            }
        }
    }

}