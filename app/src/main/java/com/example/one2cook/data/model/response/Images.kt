package com.example.one2cook.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Images(
    @Json(name = "REGULAR")
    val regularImage: RegularImage,
    @Json(name = "SMALL")
    val smallImage: SmallImage,
    @Json(name = "THUMBNAIL")
    val thumbnailImage: ThumbnailImage
)