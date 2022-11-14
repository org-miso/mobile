package com.vinyls.mobile.dto

import com.google.gson.annotations.SerializedName
import com.vinyls.mobile.model.Track
import java.util.*

data class AlbumDTO(
                    @SerializedName("name")
                    var name: String? = null,

                    @SerializedName("cover")
                    var cover: String? = null,

                    @SerializedName("releaseDate")
                    var releaseDate: String? = null,

                    @SerializedName("description")
                    var description: String? = null,

                    @SerializedName("genre")
                    var genre: String? = null,

                    @SerializedName("recordLabel")
                    var recordLabel: String? = null,

                    @SerializedName("id")
                    var id: Int? = null,

                    @SerializedName("tracks")
                    var tracks: List<TrackDTO>? = null
                )
