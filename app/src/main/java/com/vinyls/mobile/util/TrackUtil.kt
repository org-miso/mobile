package com.vinyls.mobile.util

import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.dto.TrackDTO
import com.vinyls.mobile.model.Album
import com.vinyls.mobile.model.Track

class TrackUtil {

    fun DTOtoEntity(entity: TrackDTO): Track?{
        var response : Track? = Track()
        response?.id = entity?.id
        response?.name = entity?.name
        response?.duration = entity?.duration

        return response
    }

}