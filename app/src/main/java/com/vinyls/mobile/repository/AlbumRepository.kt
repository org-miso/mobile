package com.vinyls.mobile.repository

import com.vinyls.mobile.dto.AlbumDTO

interface AlbumRepository {

    fun getAll(): List<AlbumDTO>
    fun getOneById(id: Int): AlbumDTO

}