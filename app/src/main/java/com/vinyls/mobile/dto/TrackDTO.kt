package com.vinyls.mobile.dto

import com.google.gson.annotations.SerializedName

class TrackDTO(    @SerializedName("name")
                   var name: String? = null,

                   @SerializedName("duration")
                   var duration: String? = null,

                   @SerializedName("id")
                   var id: Int? = null,

)