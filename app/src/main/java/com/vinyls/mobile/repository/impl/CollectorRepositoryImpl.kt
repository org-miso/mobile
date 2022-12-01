package com.vinyls.mobile.repository.impl

import android.util.Log
import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.dto.TrackDTO
import com.vinyls.mobile.model.Collector
import com.vinyls.mobile.repository.AlbumRepository
import com.vinyls.mobile.repository.CollectorRepository
import com.vinyls.mobile.repository.util.RetrofitHelper
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Callback

class CollectorRepositoryImpl : CollectorRepository {

    private val retrofit = RetrofitHelper.getRetrofit()

    override suspend fun getAll(): List<Collector> {
        var response = retrofit.create(CollectorAPI :: class.java).getAllCollectors()
        Log.i("SALIDA **", response.toString())
        return response.body() ?: emptyList()
    }


}
