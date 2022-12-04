package com.vinyls.mobile.model

import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.dto.TrackDTO


data class Collector(var id: Int? = null,
                     var name: String? = null,
                     var telephone: String? = null,
                     var email: String? = null,
                     var collectorAlbums: List<Album>? = null)

