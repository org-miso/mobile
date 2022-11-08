package com.vinyls.mobile.repository

import com.vinyls.mobile.model.Musician

interface MusicianRepository {

    suspend fun getAll(): List<Musician>
    fun getOneById(id: Int): Musician

}