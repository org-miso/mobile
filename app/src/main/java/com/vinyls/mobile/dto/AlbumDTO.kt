package com.vinyls.mobile.dto

import java.util.*

data class AlbumDTO(var name: String? = null,
                    var cover: String? = null,
                    var releaseDate: Date? = null,
                    var description: String? = null,
                    var genre: String? = null,
                    var recordLabel: String? = null,
                    var id: Int? = null
                )
