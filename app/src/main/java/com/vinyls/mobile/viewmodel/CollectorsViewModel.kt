package com.vinyls.mobile.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinyls.mobile.model.Collector
import com.vinyls.mobile.repository.impl.CollectorRepositoryImpl
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