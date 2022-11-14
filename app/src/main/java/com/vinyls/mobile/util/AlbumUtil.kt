package com.vinyls.mobile.util

import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.model.Album
import com.vinyls.mobile.model.Track

class AlbumUtil {

    fun DTOtoEntity(entity: AlbumDTO): Album?{
        var response : Album? = Album()
        response?.id = entity?.id
        response?.description = entity?.description
        response?.cover = entity?.cover
        response?.name = entity?.name
        response?.genre = entity?.genre
        response?.recordLabel = entity?.recordLabel
        response?.releaseDate = entity?.releaseDate
        response?.year = entity?.releaseDate?.substring(0,4)
        val tracks = entity?.tracks?.asSequence()?.map { a -> TrackUtil().DTOtoEntity(a) }?.toList()
        response?.tracks = tracks as List<Track>?
        return response
    }

}