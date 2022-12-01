package com.vinyls.mobile.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.dto.TrackDTO
import com.vinyls.mobile.model.Album
import com.vinyls.mobile.model.Collector
import com.vinyls.mobile.repository.AlbumRepository
import com.vinyls.mobile.repository.impl.AlbumRepositoryImpl
import com.vinyls.mobile.repository.impl.CollectorRepositoryImpl
import com.vinyls.mobile.util.AlbumUtil
import kotlinx.coroutines.launch

class CollectorsViewModel(): ViewModel() {

    private val collectorRepository = CollectorRepositoryImpl()

    var collectors = MutableLiveData<List<Collector?>>()

    fun getAllCollectors() {
        viewModelScope.launch {
            var data: List<Collector>? = collectorRepository.getAll()
            if (!data.isNullOrEmpty()){
                collectors.postValue(data)
            }
        }
    }



}