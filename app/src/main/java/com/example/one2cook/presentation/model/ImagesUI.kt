package com.example.one2cook.presentation.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImagesUI(
    @Json(name = "REGULAR")
    val regularImageUI: RegularImageUI,
    @Json(name = "SMALL")
    val smallImageUI: SmallImageUI,
    @Json(name = "THUMBNAIL")
    val thumbnailImageUI: ThumbnailImageUI
)