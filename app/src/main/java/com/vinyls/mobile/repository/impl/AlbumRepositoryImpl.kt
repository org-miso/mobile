package com.vinyls.mobile.repository.impl

import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.repository.AlbumRepository
import com.vinyls.mobile.repository.util.RetrofitHelper

class AlbumRepositoryImpl : AlbumRepository {

    private val retrofit = RetrofitHelper.getRetrofit()

    override suspend fun getAll(): List<AlbumDTO> {
        var response = retrofit.create(VinylsAlbumsAPI :: class.java).getAllAlbums()
        return response.body() ?: emptyList()
    }

    override fun getOneById(id: Int): AlbumDTO {
        TODO("Not yet implemented")
    }

}
