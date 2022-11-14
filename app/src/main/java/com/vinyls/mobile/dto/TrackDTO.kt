package com.vinyls.mobile.dto

import com.google.gson.annotations.SerializedName
import com.vinyls.mobile.model.Track

class TrackDTO(    @SerializedName("name")
                   var name: String? = null,

                   @SerializedName("duration")
                   var duration: String? = null,

                   @SerializedName("id")
                   var id: Int? = null,

)