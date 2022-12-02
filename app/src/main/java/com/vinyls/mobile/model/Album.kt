package com.vinyls.mobile.model

data class Album(var name: String? = null,
                 var cover: String? = null,
                 var releaseDate: String? = null,
                 var description: String? = null,
                 var genre: String? = null,
                 var recordLabel: String? = null,
                 var year: String? = null,
                 var id: Int? = null,
                 var tracks: List<Track>? = null

)

