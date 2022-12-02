package com.vinyls.mobile.repository.impl

import android.util.Log
import com.vinyls.mobile.model.Collector
import com.vinyls.mobile.repository.CollectorRepository
import com.vinyls.mobile.repository.util.RetrofitHelper

class CollectorRepositoryImpl : CollectorRepository {

    private val retrofit = RetrofitHelper.getRetrofit()

    override suspend fun getAll(): List<Collector> {
        var response = retrofit.create(CollectorAPI :: class.java).getAllCollectors()
        Log.i("SALIDA **", response.toString())
        return response.body() ?: emptyList()
    }


}
