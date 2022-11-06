package com.vinyls.mobile.util

import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.model.Album

class AlbumUtil {

    fun DTOtoEntity(entity: AlbumDTO): Album?{
        var response : Album? = Album()
        response?.id = entity?.id
        response?.description = entity?.description
        response?.id = entity?.id
        response?.cover = entity?.cover
        response?.name = entity?.name
        response?.genre = entity?.genre
        response?.recordLabel = entity?.recordLabel
        response?.releaseDate = entity?.releaseDate
        response?.year = entity?.releaseDate
        return response
    }
}