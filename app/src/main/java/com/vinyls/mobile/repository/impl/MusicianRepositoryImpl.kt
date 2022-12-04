package com.vinyls.mobile.repository.impl

import com.vinyls.mobile.model.Musician
import com.vinyls.mobile.repository.MusicianRepository
import com.vinyls.mobile.repository.util.RetrofitHelper

class MusicianRepositoryImpl : MusicianRepository {

    private val retrofit = RetrofitHelper.getRetrofit()

    override suspend fun getAll(): List<Musician> {
        var response = retrofit.create(VinylsMusicianAPI :: class.java).getAllMusicians()
        return response.body() ?: emptyList()
    }

    override fun getOneById(id: Int): Musician {
        TODO("Not yet implemented")
    }

}
