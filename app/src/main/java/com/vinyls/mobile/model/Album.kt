package com.vinyls.mobile.model

import java.util.*

data class Album(var name: String? = null,
                 var cover: String? = null,
                 var releaseDate: String? = null,
                 var description: String? = null,
                 var genre: String? = null,
                 var recordLabel: String? = null,
                 var year: String? = null,
                 var id: Int? = null
                )

