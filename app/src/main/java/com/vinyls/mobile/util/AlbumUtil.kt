package com.vinyls.mobile.util

import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.model.Album

class AlbumUtil {

    fun DTOtoEntity(entity: AlbumDTO): Album?{
        var dto : Album? = Album()
        dto?.id = entity.id
        //dto.year =
        return dto
    }
}