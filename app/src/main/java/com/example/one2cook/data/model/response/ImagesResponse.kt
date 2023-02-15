package com.example.one2cook.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImagesResponse(
    @Json(name = "REGULAR")
    val regularImageResponse: RegularImageResponse? = null,
    @Json(name = "SMALL")
    val smallImageResponse: SmallImageResponse? = null,
    @Json(name = "THUMBNAIL")
    val thumbnailImageResponse: ThumbnailImageResponse? = null
)