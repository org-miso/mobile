package com.vinyls.mobile.repository

import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.dto.TrackDTO
import com.vinyls.mobile.model.Collector

interface CollectorRepository {

    suspend fun getAll(): List<Collector>

}